class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. total length가 같아야 하고
        // 2. 각 글자의 구성이 같아야 하고
        // 3. 각 글자의 개수가 같아야 한다

        //if(s.length != t.length) {
        if(s.length() != t.length()){
            return false;
        }

        // 가장 간단한 건, sort해서 하나씩 비교하면 되잖아
        // 그런데 그건 비효율적일 거란 말이지
        // 나는 loop 돌리려고 했는데 페르가 우선 sort해서 String comparison 하래
        // String.sort(s); //nlogn?
        // String.sort(t); //nlogn?

        // char[] charsS = s.toCharArray();
        // Arrays.sort(charsS);
        // String sortedS = new String(charsS);

        // char[] charsT = t.toCharArray();
        // Arrays.sort(charsT);
        // String sortedT = new String(charsT);

        // if(sortedS.equals(sortedT)) {
        //     return true ;
        // } else {
        //     return false;
        // }

        // 내가 방금 페르한테 배운 걸로
        // Map<String, Integer> characterMap = new HashMap<>();
        Map<Character, Integer> characterMap = new HashMap<>();
        // 그런데 만약에 이렇게 하면 String s, String t 둘 다 비교해야 하잖아, 아닌가?
        // HashMap을 쓰면서 하나만 관리하면 되는 방법이 있을까?

        // s에 대해서 HashMap 하나 만들고, t에 대해서 HashMap 하나 만들어
        for(int i = 0; i < s.length(); i++){
            if(!characterMap.containsKey(s.charAt(i))){
                characterMap.put(s.charAt(i), 1);
            } else {
                // 이게 맞는지 모르겠어
                characterMap.put(s.charAt(i), characterMap.get(s.charAt(i))+1);
            }
        }

        for(int i=0; i < t.length(); i++){
            if(!characterMap.containsKey(t.charAt(i))){
                return false;
            } else {
                // characterMap.put(t.charAt(i), characterMap.get(i)-1);
                characterMap.put(t.charAt(i), characterMap.getOrDefault(t.charAt(i), 0) - 1);
            }

            if(characterMap.get(t.charAt(i))<0) {
                return false;
            }
        }
        return true;
    }
}
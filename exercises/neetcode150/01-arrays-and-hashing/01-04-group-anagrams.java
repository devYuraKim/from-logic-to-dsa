//Fri Apr 24
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> wordMap = new HashMap<>();
        //Map<String, String> wordMap = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] characterCount = new int[26];
            //char[] characterArray = new char[26];
            for(int j = 0; j < strs[i].length(); j++){
                characterCount[strs[i].charAt(j)-'a']++;
                //characterArray[strs[i].charAt(j)-'a'] = strs[i].charAt(j);
            }
            String wordKey = Arrays.toString(characterCount);
            if(wordMap.containsKey(wordKey)){
                //if(wordMap.hasKey(wordKey)){
                wordMap.get(wordKey).add(strs[i]);
                //wordMap.add(strs[i]);
            }else{
                wordMap.put(wordKey, new ArrayList<>(Arrays.asList(strs[i])));
                //wordMap.add(wordKey, strs[i]);
            }
        }

        return new ArrayList<>(wordMap.values());
        //return wordMap;

    }
}

// HashMap을 만들어서
// key를 알파벳+개수 조합으로 만들고, value를 단어로 넣는다


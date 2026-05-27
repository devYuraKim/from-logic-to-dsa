// Wed May 27 2026
// 18'51'' + LLM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;

        Set<Character> charSet = new HashSet<>();
        int output = 0;

        for(int right=0; right<s.length(); right++){
            char rc = s.charAt(right);
            char lc = s.charAt(left);

            if(charSet.add(rc)){
                output = Math.max(output, right-left+1);
            }else{
                while(lc!=rc){
                    charSet.remove(lc);
                    left++;
                    //아래 한 줄 추가
                    lc = s.charAt(left);
                }
                //아래 세 줄 추가
                charSet.remove(lc);
                left++;
                charSet.add(rc);
            }
        }

        return output;
    }
}

// for (int right = 0; right < s.length(); right++) {
//     while (set.contains(s.charAt(right))) {
//         set.remove(s.charAt(left));
//         left++;
//     }
//     set.add(s.charAt(right));
//     output = Math.max(output, right - left + 1);
// }
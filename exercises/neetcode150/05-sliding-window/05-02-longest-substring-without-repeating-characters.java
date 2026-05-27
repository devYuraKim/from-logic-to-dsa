// Wed May 27 2026
// 18'51'' + LLM
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left=0;
        int right=0;

        int output=0; //maxLength

        Set<Character> charSet = new HashSet<>();

        while(left<=right && right < s.length()){

            if(charSet.add(s.charAt(right))){
                right++;
            }else{
                int newLeft = s.indexOf(s.charAt(right), left)+1;
                for(int i=left; i<newLeft; i++){
                    charSet.remove(s.charAt(i));
                }
                left = newLeft;
                charSet.add(s.charAt(right));
                right++;
            }

            output = Math.max(output, right-left);

        }

        return output;

    }
}

// abcdeccdba
// abcde
//    dec
//       cdba
// Fri May 22 2026
// 8'29'' + LLM Feedback
// line 17, 22: while 조건문에 left<right 안 넣었음
// line 19, 24: leftChar, rightChar 재할당 안 했었음
// line 31, 32: left++, right-- 안 넣었음

class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            while(left<right && !Character.isLetterOrDigit(leftChar)){
                left++;
                leftChar = Character.toLowerCase(s.charAt(left));
            }

            while(left<right && !Character.isLetterOrDigit(rightChar)){
                right--;
                rightChar = Character.toLowerCase(s.charAt(right));
            }

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;

        }

        return true;

    }
}

// left=0, right=legnth-1
// leftChar = w, rightChar = ?
// left=0, right=legnth-2(w)
// leftChar = w, rightChar = w

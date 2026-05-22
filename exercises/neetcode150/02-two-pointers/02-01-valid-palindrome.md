### My Code
```java
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
```

### Polished Code
```java
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            while(left<right && !Character.isLetterOrDigit(leftChar)){
                left++;
            }

            while(left<right && !Character.isLetterOrDigit(rightChar)){
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;

        }

        return true;

    }
}
}
```
### My Code
```java
class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else{
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
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
        int right = s.length() - 1;

        while (left < right) {

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } 
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } 
            else {

                if (Character.toLowerCase(leftChar) !=
                    Character.toLowerCase(rightChar)) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
```
class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        char[] charArray = lowerCase.toCharArray();

        int leftPointer = 0;
        int rightPointer = charArray.length-1;

        while(leftPointer < rightPointer){ //이렇게 해야 leftPointer++ 했을 때 rightPointer랑 같아질 수 있으니까
            //while(leftPointer <= rightPointer){
            while(leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[leftPointer])){
                //if(leftPointer < rightPointer) leftPointer++; // 이거 했더니 Inifinite Loop 발생
                leftPointer++;
            }
            while(leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[rightPointer])){
                //if(leftPointer < rightPointer) rightPointer--;
                rightPointer--;
            }

            if(charArray[leftPointer]==charArray[rightPointer]){
                leftPointer++;
                //rightPointer++;
                rightPointer--;
            }else{
                return false;
            }
        }

        return true;

    }
}
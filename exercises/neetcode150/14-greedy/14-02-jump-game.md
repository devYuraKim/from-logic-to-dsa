### My Original Code
// Tue May 19 2026     
// 13'51''
```java
class Solution {
    public boolean canJump(int[] nums) {

        int maxIndex = 0;

        for(int i=0; i<nums.length-1; i++){

            int possibleLimit = i+nums[i];
            
            if(possibleLimit == i){
                if(maxIndex == i){
                    return false;
                }
                continue;
            }
            if(possibleLimit > maxIndex){
                maxIndex = possibleLimit;
            }

        }

        return maxIndex >= nums.length-1 ? true: false;

    }
}
```

### Polished Code
```java
class Solution {
    public boolean canJump(int[] nums) {
        
        int maxIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return maxIndex >= nums.length - 1;
    }
}
```
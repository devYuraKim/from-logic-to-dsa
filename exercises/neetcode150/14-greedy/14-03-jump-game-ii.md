### First Try
```java
class Solution {
    public int jump(int[] nums) {
        
        int output=0;
        int curMax=0;
    
        for(int i=0; i<nums.length-1; i++){
            if(curMax==i){
                output++;
            }
            if(curMax < i+nums[i]){
                curMax = i+nums[i];
            }
            if(curMax>=nums.length-1){
                return output;
            }
        }
        return output;
    }
}
```
- curEnd와 curMax를 분리하여 관리하지 않음

### Second Try
```java
class Solution {
    public int jump(int[] nums) {
        
        int jumpCount=0;
        int curEnd=0;
        int curMax=0;

        for(int i=0; i<nums.length-1; i++){
            if(curEnd==i){
                jumpCount++;
                curEnd = curMax;
            }
            if(curMax < i+nums[i]){
                curMax = i+nums[i];
                curEnd = curMax;
            }
            if(curMax >= nums.length-1){
                return jumpCount;
            }
        }
        return jumpCount;
    }
}
```
- curEnd를 두 군데에서 업데이트함

### Third Try
```java
class Solution {
    public int jump(int[] nums) {
        
        int jumpCount=0;
        int curEnd=0;
        int curMax=0;

        for(int i=0; i<nums.length-1; i++){
            if(curEnd==i){
                jumpCount++;
                curEnd = curMax;
            }
            if(curMax < i+nums[i]){
                curMax = i+nums[i];
            }
            if(curMax >= nums.length-1){
                return jumpCount;
            }
        }
        return jumpCount;
    }
}
```
- curMax 업데이트를 curEnd 업데이트 뒤에 함
- curMax >= nums.length-1 early return 되어버림
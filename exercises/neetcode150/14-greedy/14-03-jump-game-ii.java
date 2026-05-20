// Wed May 20
// 51' 06'' + LLM
class Solution {
    public int jump(int[] nums) {

        int jumpCount=0;
        int curEnd=0;
        int curMax=0;

        for(int i=0; i<nums.length-1; i++){
            if(curMax < i+nums[i]){
                curMax = i+nums[i];
            }

            if(curEnd==i){
                jumpCount++;
                curEnd = curMax;
            }
        }
        return jumpCount;
    }
}
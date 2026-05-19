// Tue May 19 2026
// 07'46''
class Solution {
    public int maxSubArray(int[] nums) {

        int curSum = 0;
        int output = nums[0];

        for(int i=0; i<nums.length; i++){
            curSum += nums[i];

            if(curSum > output) {
                output = curSum;
            }

            if(curSum < 0){
                curSum = 0;
            }
        }

        return output;
    }
}
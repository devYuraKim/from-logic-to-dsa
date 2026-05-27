// Wed May 27 2026
// 5'48''
class Solution {
    public int maxSubArray(int[] nums) {

        int output = nums[0];
        int curSum = 0;

        for(int i=0; i<nums.length; i++){
            curSum += nums[i];

            output = Math.max(output, curSum);

            if(curSum < 0){
                curSum = 0;
                continue;
            }
        }

        return output;

    }
}


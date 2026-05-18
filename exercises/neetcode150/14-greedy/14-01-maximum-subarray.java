class Solution {
    public int maxSubArray(int[] nums) {

        int curSum = 0;
        int output = nums[0];

        for(int i=0; i<nums.length; i++){
            curSum += nums[i];

            if(curSum > output){
                output = curSum;
            }

            if(curSum < 0){
                curSum = 0;
            }
        }

        return output;
    }
}

// curSum = 0, output = -3
// curSum = -3, output = -3

//[-3]
// curSum = 0, output = -3
// curSum = -3 -> true -> curSum = 0, true -> output = 0;
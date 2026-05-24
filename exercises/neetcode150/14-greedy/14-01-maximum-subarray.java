// Sun May 24 2026
// 14'45''

// May 19 07'46''에 비해 늦어지고
// if-if 처리해야 하는데 if-else if로 처리함 (여기서 문제는 없음)
class Solution {
    public int maxSubArray(int[] nums) {

        int output = nums[0];
        int curSum = 0;

        for(int i=0; i<nums.length; i++){
            curSum += nums[i];

            //
            if(output < curSum){
                output = curSum;
            }else if(curSum < 0){
                curSum = 0;
            }
        }

        return output;
    }
}

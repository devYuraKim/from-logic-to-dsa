// Mon May 18
// 결국에는 Brute Force
// 21'28''
class Solution {
    public int maxSubArray(int[] nums) {

        int curSum = 0;
        int output = nums[0];

        for(int i=0; i<nums.length; i++){
            curSum = 0;
            for(int j=i; j<nums.length; j++){
                curSum += nums[j];
                if(curSum > output){
                    output = curSum;
                }
            }
        }

        return output;

    }
}

// 2, -3, 4, -2, 2, 1, -1, 4
// minIdx: 0
// maxIdx: nums.length-1;
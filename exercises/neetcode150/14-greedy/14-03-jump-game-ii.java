// Wed May 27 2026
// 11'29''
class Solution {
    public int jump(int[] nums) {

        int maxLimit = 0;
        int currentLimit = 0;
        int jumps = 0;

        for(int i=0; i<nums.length-1; i++){

            if(maxLimit < i+nums[i]){
                maxLimit = i+nums[i];
            }

            if(i == currentLimit){
                jumps++;
                currentLimit = maxLimit;
            }

        }

        return jumps;

    }
}

// i=0, maxLimit=2, currentLimit=2
// i=1, maxLimit=5, currentLimit=2
// i=2, maxLimit=5, currnetLimit=i jump=1, currentLimit=maxLimit=5
// i=3, maxLimit=5, currentLimit=5
// i=4, maxLimit=5, currentLimit=5
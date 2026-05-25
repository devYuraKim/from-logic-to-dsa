// Mon May 25 2026
// over an hour and a half + LLM
class Solution {
    public int jump(int[] nums) {

        int localMax = 0;
        int globalMax = 0;
        int jumps = 0;

        for(int i=0; i<nums.length-1; i++){
            if(globalMax < i+nums[i]){
                globalMax = i+nums[i];
            }
            // 이 문제 조건에서는 상관 없지만 엄밀히는 localMax==i 해야 한다.
            if(localMax <= i){
                jumps++;
                localMax = globalMax;
            }
        }

        return jumps;

    }
}
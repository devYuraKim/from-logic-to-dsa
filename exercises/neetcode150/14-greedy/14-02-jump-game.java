// Sun May 24 2026
// 7'30''
class Solution {
    public boolean canJump(int[] nums) {

        int curMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (curMax < i) return false;
            curMax = Math.max(curMax, i + nums[i]);
        }
        return true;

        // int curMax = nums[0];
        // for(int i=0; i<nums.length-1; i++){
        //     int nextIndex = i+nums[i];
        //     if(nextIndex <= i){
        //         //여기서는 점프 못 함.. 그냥 끼어 있음
        //         if(curMax <= i){
        //             return false;
        //         }else {
        //             continue;
        //         }
        //     }else{
        //         curMax = Math.max(curMax, nextIndex);
        //     }
        // }
        // return true;
    }
}
//Sun May 17 2026
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums[0];
        for(int i=0; i<nums.length-1; i++){
            if(farthest < i+nums[i]){
                farthest = i+nums[i];
            }else if(farthest <= i){
                return false;
            }
        }
        return true;
    }
}

// (0,1,2)
// [0,2,3]
// <-,3,5>

// (0,1,2,3,4)
// [1,2,0,1,0]
// <1,3,-,4,->

// (0,1,2,3)
// [1,0,1,0]
// <1,-,3,->

// (0)
// [0]
// <->

// (0,1,2,3)
// [1,0,1,0]
// <1,-,3,->
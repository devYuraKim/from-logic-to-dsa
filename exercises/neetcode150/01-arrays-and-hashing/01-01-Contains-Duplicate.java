//Tue Nov 24 2026
//05'55''
class Solution {
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}
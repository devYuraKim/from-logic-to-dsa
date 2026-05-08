// Sat May 9 2026
// 6'54''

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(compMap.containsKey(comp)){
                return new int[]{compMap.get(comp), i};
            }
            compMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

// i==0: comp=6 if(false) compMap({4:0})
// i==1: comp=5 if(false) compMap({4:0, 5:1})
// i==2: comp=4 if(true) return [0, 2]
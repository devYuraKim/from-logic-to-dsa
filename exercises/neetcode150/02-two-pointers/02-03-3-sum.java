//Fri May 22 2026
// 13'47''

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        //duplicates
        //O(nlogn)
        Arrays.sort(nums);

        //O(n)
        for(int i=0; i<nums.length-2; i++){
            int left=i+1;
            int right=nums.length-1;

            // duplicate i skip
            if(i>0 && nums[i-1]==nums[i]) continue;

            // -1, -1, 0, 1
            // i==0 nums[i]=-1
            // left==1 nums[left]=-1
            // right==3 nums[right]=0
            // left++ left==2 nums[left]=

            // i<left<right
            while(left<right){

                // long in case of overflow
                long sum = nums[i]+nums[left]+nums[right];

                if(sum==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    output.add(new ArrayList<>(triplet));
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return output;
    }
}

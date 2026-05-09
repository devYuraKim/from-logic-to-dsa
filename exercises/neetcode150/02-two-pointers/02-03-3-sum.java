//Sat May 09 2026
//37'54''
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); // [-4, -1, -1, 0, 1, 2]

        List<List<Integer>> output = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){

            int left = i+1;
            int right = nums.length-1;

            if(i>=1 && nums[i]==nums[i-1]) continue;

            while(left<right){
                int sum = nums[left]+nums[i]+nums[right];

                if(sum < 0){
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                } else if(sum > 0){
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    output.add(new ArrayList<>(temp));

                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }

        }

        return output;

    }
}

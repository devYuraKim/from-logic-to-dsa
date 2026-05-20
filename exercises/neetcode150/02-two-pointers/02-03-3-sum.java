// Wed May 20 2026
// 25'15'' + LLM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> triplet = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    while(nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                }else if(sum<0){
                    while(nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                }else{
                    output.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            };
        }

        return output;

    }
}

// for loop으로 i=0..length-1까지 전진시키면서 duplicate 제외
// (변경) nums sort해서 중복 처리 가능하도록 + for loop으로 i=0부터 length-1까지 전진시키면서 duplicate 제외
// [-4, -1, -1, 0, 1, 2]
// i=0 left=i+1=1, right=length-1
//     while(left<right)
//     nums[i]+nums[left]+nums[right]<0: left++;
//     nums[i]+nums[left]+nums[right]>0: right--;
//     nums[i]+nums[left]+nums[right]=0: add하고 continue? left++, right--
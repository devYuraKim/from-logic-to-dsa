//Sun May 10 2026
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        // [1오류] 순회 i 종료 조건
        // for(int i=0; i<nums.length-2; i++){
        for(int i=0; i<nums.length; i++){

            // [2오류] early break
            // if (nums[i] > 0) break;

            int left = i+1;
            int right = nums.length-1;

            // [3오류] nums[i] 중복 처리
            // if(i > 0 && nums[i]==nums[i-1]) continue;

            while(left < right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    // [4오류] Arrays.asList()
                    //List<Integer> tempList = Arrays.asList(nums[i], nums[left], nums[right]);
                    List<Integer> tempList = List.asList(nums[i], nums[left], nums[right]);
                    output.add(new ArrayList<>(tempList));
                    // [5오류] left, right는 '이후 원소'와 비교, i는 '이전 원소'와 비교
                    //while(left < right && nums[left]==nums[left+1]
                    while(left < right && nums[left-1]==nums[left]) {
                        left++;
                    }
                    left++;
                    while(left < right && nums[right-1]==nums[right]) {
                        right--;
                    }
                    right--;
                }else if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }

        }

        return output;

    }
}
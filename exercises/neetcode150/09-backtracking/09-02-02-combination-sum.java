class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursion(nums, target, output, tempList, 0);

        return output;

    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> tempList, int startIndex){

        //종료조건
        if(target == 0) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        //early return
        if(target < 0 || startIndex == nums.length) {
            return;
        }

        // nums[startIndex] 원소 포함: 같은 후보 유지
        tempList.add(nums[startIndex]);
        recursion(nums, target-nums[startIndex], output, tempList, startIndex);

        // nums[startIndex] 원소 미포함: 다음 후보로 이동
        tempList.remove(tempList.size()-1);
        recursion(nums, target, output, tempList, startIndex+1);

    }

}
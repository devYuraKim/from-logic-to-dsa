// Tue May 12 2026
// 08:59
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursion(nums, target, output, tempList, 0);

        return output;

    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> tempList, int startIndex){

        if(target == 0){
            output.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0 || startIndex >= nums.length){
            return;
        }

        //해당 원소를 선택
        tempList.add(nums[startIndex]);
        recursion(nums, target-nums[startIndex], output, tempList, startIndex);

        //해당 원소를 미선택
        tempList.remove(tempList.size()-1);
        recursion(nums, target, output, tempList, startIndex+1);

    }
}

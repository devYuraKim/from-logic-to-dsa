// Tue May 12 2026
// 11:51
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursive(nums, output, tempList, 0);

        return output;

    }

    public void recursive(int[] nums, List<List<Integer>> output, List<Integer> tempList, int startIndex){

        if(startIndex == nums.length) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        // 해당 원소 포함
        tempList.add(nums[startIndex]);
        recursive(nums, output, tempList, startIndex+1);

        // 해당 원소 미포함
        tempList.remove(tempList.size()-1);
        recursive(nums, output, tempList, startIndex+1);

    }
}

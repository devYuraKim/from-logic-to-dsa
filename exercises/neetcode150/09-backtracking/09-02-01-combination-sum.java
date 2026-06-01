// Mon Jun 1 2026
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<Integer> combi = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        recursion(nums, combi, output, target, 0);

        return output;

    }

    private void recursion(int[] nums,  List<Integer> combi, List<List<Integer>> output, int target, int index){

        // target==0이 되면
        if(target == 0){
            output.add(new ArrayList<>(combi));
            return;
        }else if(target < 0 || index == nums.length){
            return;
        }else{
            //해당 원소 포함
            combi.add(nums[index]);
            recursion(nums, combi, output, target-nums[index], index);

            //해당 원소 미포함
            combi.remove(combi.size()-1);
            recursion(nums, combi, output, target, index+1);
        }

    }
}

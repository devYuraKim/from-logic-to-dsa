// try1
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        recursion(nums, target, output, combination, 0);

        return output;
    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> combination, int currentIndex){

        if(target - nums[currentIndex] == 0){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(target - nums[currentIndex] < 0){
            return;
        }

        for(int i = currentIndex; i < nums.length; i++){
            //nums[currentIndex]를 포함한 모든 경우
            combination.add(nums[currentIndex]);
            recursion(nums, target-nums[currentIndex], output, combination, currentIndex);
            //nums[currentIndex]를 포함하지 않도록
            combination.remove(combination.size()-1);
        }

    }

}

//try2
// 41:18

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        recursion(nums, target, output, combination, 0);

        return output;
    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> combination, int currentIndex){

        if(target == 0){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = currentIndex; i < nums.length; i++){
            //nums[currentIndex]를 포함한 모든 경우
            combination.add(nums[i]);
            recursion(nums, target-nums[i], output, combination, i);
            //nums[currentIndex]를 포함하지 않도록
            combination.remove(combination.size()-1);
        }

    }

}
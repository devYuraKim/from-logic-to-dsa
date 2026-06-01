// Mon Jun 1 2026
// 18'17''

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        recursion(nums, subset, output, 0);

        return output;

    }

    void recursion(int[] nums, List<Integer> subset, List<List<Integer>> output, int index){

        //여기를 if(index == nums.length-1)로 하다가 dry run 해보고 오류 잡음
        if(index == nums.length){
            output.add(new ArrayList<>(subset));
        }else{
            //else if도 되지만, else가 더 효율적임
            //}else if(index < nums.length){
            // 해당 원소 포함
            subset.add(nums[index]);
            recursion(nums, subset, output, index+1);

            // 해당 원소 미포함
            subset.remove(subset.size()-1);
            recursion(nums, subset, output, index+1);
        }

    }
}

// index=0: subset [1] recursion(nums, [1], output, 1) || subset [] recursion(nums, [], output, 1)
//          subset [1,2] recursion(nums, [1,2], output, 2) | subset [1] recursion(nums, [1], output, 2) ||
//          subset [1,2,3] recursion(nums, [1,2,3], output, 3) & subset [1,2] recursion(nums, [1,2], output, 3)
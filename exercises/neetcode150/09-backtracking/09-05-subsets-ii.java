// Tue May 12 2026
// 11'03''

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        recursion(nums, subset, output, 0);

        return output;
    }

    public void recursion(int[] nums, List<Integer> subset, List<List<Integer>> output, int index){

        if(index == nums.length){
            output.add(new ArrayList<>(subset));
            return;
        }

        if(index > nums.length){
            return;
        }

        // 해당 원소를 선택
        subset.add(nums[index]);
        recursion(nums, subset, output, index+1);

        // 해당 원소를 미선택
        subset.remove(subset.size()-1);
        while(index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }
        recursion(nums, subset, output, index+1);
    }
}

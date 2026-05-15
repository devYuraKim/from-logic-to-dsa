// Fri May 15 2026
// 10'17''
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursion(nums, output, tempList, 0);

        return output;

    }

    public void recursion(int[] nums, List<List<Integer>> output, List<Integer> tempList, int startIdx){

        if(startIdx==nums.length){
            output.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0; i<tempList.size()+1; i++){
            tempList.add(i, nums[startIdx]);
            recursion(nums, output, tempList, startIdx+1);
            // 또 이거 안 넣음!!!!!
            tempList.remove(i);
        }
    }
}

// [1]
// [1,2] [2,1]
// [3,1,2] [1,3,2] [1,2,3] [3,2,1] [2,3,1] [2,1,3]
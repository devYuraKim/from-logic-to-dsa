// 20:35
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> interim = new ArrayList<>();

        getPermutations(nums, output, interim, 0);

        return output;

    }

    public void getPermutations(int[] nums, List<List<Integer>> output, List<Integer> interim, int curIdx){

        if(interim.size() == nums.length || curIdx == nums.length){
            output.add(new ArrayList<>(interim));
            return;
        }

        for(int i = 0; i<=interim.size(); i++){
            interim.add(i, nums[curIdx]);
            getPermutations(nums, output, interim, curIdx+1);
            //이걸 안 했었다
            interim.remove(i);
        }

    }

    // [1]
    // [2,1] [1,2]
    // [3,2,1] [2,3,1] [2,1,3] [3,1,2] [1,3,2] [1,2,3]

}

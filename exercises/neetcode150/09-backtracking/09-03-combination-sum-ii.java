// Tue May 12 2026
// 08:36
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursion(candidates, output, tempList, target, 0);

        return output;

    }

    public void recursion(int[] candidates, List<List<Integer>> output, List<Integer> tempList, int target, int index){

        if(target == 0){
            output.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0 || index >= candidates.length){
            return;
        }

        //해당 요소 포함
        tempList.add(candidates[index]);
        recursion(candidates, output, tempList, target-candidates[index], index+1);

        //해당 요소 미포함
        tempList.remove(tempList.size()-1);
        while(index < candidates.length-1 && candidates[index]==candidates[index+1]){
            index++;
        }
        recursion(candidates, output, tempList, target, index+1);

    }
}

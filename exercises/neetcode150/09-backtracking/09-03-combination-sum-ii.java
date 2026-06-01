// Mon Jun 01 2026
// 10:54

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> combi = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        recursion(candidates, target, combi, output, 0);

        return output;

    }

    private void recursion(int[] candidates, int target, List<Integer> combi, List<List<Integer>> output, int index){

        if(target == 0){
            output.add(new ArrayList<>(combi));
            return;
        }else if(target < 0 || index == candidates.length){
            return;
        }else{
            //해당 원소 포함
            combi.add(candidates[index]);
            recursion(candidates, target-candidates[index], combi, output, index+1);

            //해당 원소 미포함
            combi.remove(combi.size()-1);
            while(index < candidates.length-1 && candidates[index]==candidates[index+1]){
                index++;
            }
            recursion(candidates, target, combi, output, index+1);

        }
    }

}

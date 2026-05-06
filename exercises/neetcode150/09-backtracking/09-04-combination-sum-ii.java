class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates); // [1, 2, 2, 4, 5, 6, 9]

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        recursion(candidates, target, output, tempList, 0);

        return output;

    }

    public void recursion(int[] candidates, int remaining, List<List<Integer>> output, List<Integer> tempList, int currentIndex){

        if(remaining == 0 ) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        if(remaining < 0 || currentIndex == candidates.length) {
            return;
        }

        // candidates[i]를 선택
        tempList.add(candidates[currentIndex]);
        // 그 다음 단계에서 같은 값을 가진 원소 선택 가능
        recursion(candidates, remaining-candidates[currentIndex], output, tempList, currentIndex+1);

        // candidates[i]를 미선택
        tempList.remove(tempList.size()-1);
        // 그 다음 단계에서도 같은 값을 가진 원소 선택 불가능
        while(currentIndex+1 < candidates.length && candidates[currentIndex]==candidates[currentIndex+1]){
            currentIndex++;
        }
        recursion(candidates, remaining, output, tempList, currentIndex+1);
    }
}

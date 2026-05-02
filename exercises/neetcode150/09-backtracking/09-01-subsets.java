// 6'48''
// 주의1: depth == nums.length 맞음 off by one 유념.
    // depth 0 -> 1 결정
    // depth 1 -> 2 결정
    // depth 2 -> 3 결정
    // depth 3 == nums.length -> 결과 확정
// 주의2: output.add(tempList)할 때 그냥 하면 오류 발생.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        recursion(nums, tempList, output, 0);

        return output;

    }

    public void recursion(int[] nums, List<Integer> tempList, List<List<Integer>> output, int depth){

        // 트리 바닥 도달: 모든 층의 포함/미포함 결정이 끝났으므로 output에 추가
        // off by one 주의: 트리 바닥 도달한 다음 단계에서 추가해야 하므로 depth == nums.length 맞음
        if(depth == nums.length){
            output.add(new ArrayList<>(tempList));
            return;
        }

        // depth번째 원소를 포함하는 모든 경우 탐색
        tempList.add(nums[depth]);
        recursion(nums, tempList, output, depth+1);

        // depth번째 원소 미포함하는 모든 경우 탐색
        tempList.remove(tempList.size() - 1);
        recursion(nums, tempList, output, depth+1);

    }

}
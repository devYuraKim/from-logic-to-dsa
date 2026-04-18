class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 일단 생각 나는 것부터
        // [탈락] target - nums[i]한 다음에 loop 돌면서 ... -> 이건 안 됨, 왜냐면 다른 조합이 있을 수도 있으니까

        // 이거 뭐 어쩌라는 거지...?
        // 내가 Map을 배운 뒤에 자꾸 Map으로 풀려고 하는데, 이걸로 풀어야 하는 거야?

        // indices를 return하라는 건, index 관리 필요하다

        // int[] indices = new ArrayList<>(2);
        // (1)List
        // List<Integer> indices = new ArrayList<>(2);
        int[] indices = new int[2];

        for(int i = 0; i < nums.length-1; i++){
            // 어? 3+4, 3+5, 3+6, 4+5, 4+6, 5+6 이렇게 보면 되는 거 아님?
            // 아냐... 중간에 다른 게 끼어 있을 수도 있잖아

            // 아니네...
            // [1, 6, 5, 2, 4, 3], target = 10
            // (1,6) (1,5) (1,2) (1,4) (1,3)
            // (6,5) (6,2) (6,4) (6,3)
            // (5,2) (5,4) (5,3)
            // (2,4) (2,3)
            // (4,3)
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j]==target){
                    if(i>j) {
                        indices[0] = j;
                        indices[1] = i;
                        // return indices;
                    }else{
                        indices[0] = i;
                        indices[1] = j;
                        // return indices;
                    }
                }
            }

        }
        return indices;
    }
}

// (1)List & Array 차이 (정의, 원소 할당)
// (2)For문 내부에서의 return 구문이 소용 없는 이유?
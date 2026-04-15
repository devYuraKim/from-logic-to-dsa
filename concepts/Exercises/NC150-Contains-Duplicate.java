class Solution {
    public boolean hasDuplicate(int[] nums) {

        // 뭔가 XOR로 하면 될 것 같은데
        // 이거 배타적이어야 true니까 그거 반전시키면 되지 않나?

        // 페르가 HashMap으로 해보라는데
        Map<Integer, Integer> map = new HashMap<>();
        // Key에 array value를 저장하고, Value에 해당 값의 count를 저장해서, 그 후 Map을 확인하면서 Value가 2 이상인 것들이 있는지 보려고 했는데, 굳이 그걸 저장해서 다 확인할 필요가 있냐고 물어봄
        // Key를 lookup 해서 없으면 저장하고, 있으면 바로 true return 하는 게 더 나을 것 같음.
        for(int i = 0; i < nums.length; i++){
            //map에서 key lookup 어떻게 하지?
            if(map.containsKey(nums[i])){
                // if(map.containsKey(i)) {
                return true;
            } else {
                map.put(nums[i]);
                // map.put(i, 0);
            }
        }
        return false;

        // 잠깐만, 이거 sorted 된 건가?
        // 이게 sorted가 된 거면 nums[i]랑 nums[i+1]이 같은지 다른지 보면 되는 거 아닌가?
        // sorted가 됐다고 가정하면
        // Java에서 Array sort 어떻게 해?
        // Arrays.sort(nums);

        // for(int i = 0; i < nums.length-1; i++){
        //     // java에서 XOR 처리는 어떻게 해?
        //     // 그러면 만약에 이걸 못하면 내가 할 수 있는 걸로 '돌아가는 코드'는 어떻게 만들까?
        //     if(nums[i] == nums[i+1]) return true;
        // }

        // return false;

    }
}

// 이 세가지 방식을 비교해봐야겠음
// 1. sort 해서 for loop 돌리는 경우
// 2. HashMap 써서 Key lookup 하는 경우
// 3. XOR 써보고 싶음
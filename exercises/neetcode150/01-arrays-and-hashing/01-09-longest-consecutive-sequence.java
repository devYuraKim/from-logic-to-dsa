//Sun May 17 2026

class Solution {
    public int longestConsecutive(int[] nums) {

        // 배열을 하나씩 돌면서 Map에 key는 nums[i], value는 nums[i]+1 저장
        // map.get(key)가 연결되는 가장 긴 값을 반환

        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, num+1);
        }


        int maxOutput = 0;

        for(int num:nums){
            int output = 1;
            while(map.containsKey(num) && map.containsKey(map.get(num))){
                if(map.containsKey(num)){
                    if(map.containsKey(map.get(num))){
                        output++;
                        num = map.get(num);

                    }
                }
            }
            if(output > maxOutput) {
                maxOutput = output;
            }
        }

        return maxOutput;

    }
}

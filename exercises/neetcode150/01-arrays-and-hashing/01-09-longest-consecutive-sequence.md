Sun May 17 2026

### My Code
```java
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
```

> 1. `map.containsKey(num)`는 항상 `true`니까 확인할 필요가 없음     
> 2. `while`에서 이미 `if` 조건들을 확인하고 있어서 `if` 조건 필요가 없음
    
#### Before
```java
while(map.containsKey(num) && map.containsKey(map.get(num))){
    if(map.containsKey(num)){
        if(map.containsKey(map.get(num))){
            output++;
            num = map.get(num);
        }
    }
}
```

#### After
```java
while(map.containsKey(map.get(num))){
    output++;
    num = map.get(num);
}
```

### Polished Code
```java
class Solution {

    public int longestConsecutive(int[] nums) {

        //early return
        if(nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, num + 1);
        }

        int maxOutput = 0;

        for(int num : nums){

            int output = 1;

            while(map.containsKey(map.get(num))){

                output++;
                num = map.get(num);

            }

            maxOutput = Math.max(maxOutput, output);

        }

        return maxOutput;

    }

}
```

### HashSet, 그리고 중복 탐색 없는 방식으로 다시 풀이할 것
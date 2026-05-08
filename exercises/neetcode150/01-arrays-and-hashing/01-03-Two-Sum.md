[Two Sum](https://neetcode.io/problems/two-integer-sum/question)

### My Code 
Sat May 9 2026     
6'54''

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> compMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            
            int comp = target - nums[i];
            
            if(compMap.containsKey(comp)){
                return new int[]{compMap.get(comp), i};
            }
            compMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

> **Avoid repeated lookup**
> ```java
> if(compMap.containsKey(comp)){
>      return new int[]{compMap.get(comp), i};
> }
> ```
> That performs two hash lookups.

### Improved Code
```java
class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> compMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int comp = target - nums[i];

            Integer index = compMap.get(comp);

            if (index != null) {
                return new int[]{index, i};
            }

            compMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
```
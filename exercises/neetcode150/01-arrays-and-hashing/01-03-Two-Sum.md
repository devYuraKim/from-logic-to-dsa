[Two Sum](https://neetcode.io/problems/two-integer-sum/question)

### My Code 
Thu May 7 2026     
09'07''

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];
        
        for(int i = 0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target - nums[i] - nums[j] == 0){
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        return output;

    }
}
```

### Improved Code
```java
class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        //does not reach here
        return new int[]{};
    }
}
```
1. Simplify the condition
2. Avoid unnecessary variable creation
3. Return immediately once found
```java
if(nums[i] + nums[j] == target){
    return new int[]{i, j};
}
```

### Improved Approach
Use HashMap for time complexity $O(n)$ and space complexity $O(n)$
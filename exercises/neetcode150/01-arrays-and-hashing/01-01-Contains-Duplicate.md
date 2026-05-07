[Contains Duplicate](https://neetcode.io/problems/duplicate-integer/question)

### My Code
Fri May 08 2026     
02'03''
```java

class Solution {
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }
        }

        return false;

    }
}
```

### Improved Code
```java
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
```

1. Improved For Loop
2. Using the Return Value of add()


> `set.add(value)` returns:
> - `true` if insertion succeeded
> - `false` if value already existed
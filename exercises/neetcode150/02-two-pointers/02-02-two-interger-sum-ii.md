### My Code
```java
// Fri May 22 2026
// 3'46''
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            if(numbers[left]+numbers[right] < target){
                left++;
            }else if(numbers[left]+numbers[right] > target){
                right--;
            }else{
                break;
                //left++;
                //right++;
            }
        }
        return new int[]{left+1, right+1};
    }
}

```

> `numbers[left] + numbers[right]`를 한 번만 계산해서 저장
> 
### Polished Code
```java
// Fri May 22 2026
// 3'46''
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                break;
                //left++;
                //right++;
            }
        }
        return new int[]{left+1, right+1};
    }
}

```


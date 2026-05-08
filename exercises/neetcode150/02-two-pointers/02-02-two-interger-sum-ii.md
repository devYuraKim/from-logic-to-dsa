> 문제의 조건에 array가 '정렬'되어 있으므로 two pointers로 접근

### My Code
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            if(numbers[left]+numbers[right]==target){
                return new int[]{left+1, right+1};
            }else if(numbers[left]+numbers[right] < target){
                left++;
            }else {
                right--;
            }
        }

        return new int[]{-1, -1};

    }
}
```

> `numbers[left] + numbers[right]`를 한 번만 계산해서 저장
> 
### Polished Code
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            numbers[left]+numbers[right] = sum;
            if(sum ==target){
                return new int[]{left+1, right+1};
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
        }

        return new int[]{-1, -1};

    }
}
```


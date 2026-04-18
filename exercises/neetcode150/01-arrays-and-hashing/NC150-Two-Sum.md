[Two Sum](https://neetcode.io/problems/two-integer-sum/question)

### My Code

```java
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
```

###

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    // i < j 가 보장되므로 바로 반환
                    return new int[] {i, j};
                }
            }
        }
        return new int[0]; // 논리적으로 도달하지 않음
    }
}
```

- **조건문 간소화**: 바깥쪽 루프(`i`)가 $0$부터 시작하고 안쪽 루프(`j`)가 i + 1부터 시작하므로, 항상 `i < j`가 보장. 따라서 `if(i > j)` 확인하는 분기문 불필요.
- **조기 반환** (Early Return): 문제에서 "정확히 하나의 정답이 존재한다"고 명시했으므로, 정답을 찾는 즉시 `return`하는 것이 효율적. 
  - **return 관련 에러 발생 이유**: `for`문 내부만의 `return`으로 컴파일 에러가 발생한 이유는 "**조건문(`if`)이 만족되지 않을 경우, 메서드가 무엇을 반환할지 알 수 없기 때문**". 만약 모든 루프를 돌았는데도 `target`을 찾지 못한다면, 메서드는 끝까지 실행된 후 반환할 값이 없음. 따라서 루프 바깥에 최종 `return` 문이 없으면 에러 발생.
- **불필요한 변수 제거**: `indices` 배열을 미리 선언하지 않고, 정답을 찾았을 때 바로 `new int[] {i, j}` 형태로 반환.


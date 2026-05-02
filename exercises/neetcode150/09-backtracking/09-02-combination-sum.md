

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        recursion(nums, target, output, combination, 0);

        return output;
    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> combination, int currentIndex){

        if(target - nums[currentIndex] == 0){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(target - nums[currentIndex] < 0){
            return;
        }

        for(int i = currentIndex; i < nums.length; i++){
            //nums[currentIndex]를 포함한 모든 경우
            combination.add(nums[currentIndex]);
            recursion(nums, target-nums[currentIndex], output, combination, currentIndex);
            //nums[currentIndex]를 포함하지 않도록
            combination.remove(combination.size()-1);
        }

    }

}
```

```java
// 41:18

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        recursion(nums, target, output, combination, 0);

        return output;
    }

    public void recursion(int[] nums, int target, List<List<Integer>> output, List<Integer> combination, int currentIndex){

        if(target == 0){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = currentIndex; i < nums.length; i++){
            //nums[currentIndex]를 포함한 모든 경우
            combination.add(nums[i]);
            recursion(nums, target-nums[i], output, combination, i);
            //nums[currentIndex]를 포함하지 않도록
            combination.remove(combination.size()-1);
        }

    }

}
```

## 오류1
```java
        for(int i = currentIndex; i < nums.length; i++){
            //nums[currentIndex]를 포함한 모든 경우
            combination.add(nums[currentIndex]);
            recursion(nums, target-nums[currentIndex], output, combination, currentIndex);
            //nums[currentIndex]를 포함하지 않도록
            combination.remove(combination.size()-1);
        }
```

난 이 생각으로 쓴 건데:   
currentIndex = “선택 가능한 시작점”   
그래서 for loop이 돌면 currentIndex보다 하나씩 증가할 거 아냐?  
 
그래... i의 시작을 currentIndex로 줬으니까 당연히 i를 관리해야지...


## 오류2
```java
        if(target - nums[currentIndex] == 0){
            output.add(new ArrayList<>(combination));
            return;
        }

        if(target - nums[currentIndex] < 0){
            return;
        }
```

변수명이 'target'이라서 헷갈린 것 같다...   
currentIndex가 고정된다는 문제는 차치하고도    
처음 방식은 "**미리 계산해보고 갈지 말지 결정**"하는 거고   
수정된 방식은 "**이미 계산되어서 넘어온 값을 판단**"하는 거고     
변수 이름을 `remaining`이라고 하면 덜 헷갈렸으려나

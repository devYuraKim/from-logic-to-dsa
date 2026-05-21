// Thu May 21 2026     
// 41'41'' + LLM feedback     

// stack에 온도 저장했다가, index 저장해서 array에서 값 확인하는 방향으로 바꿈     
// 마지막에 for loop temperatures.length-1까지 잡아서 off by one error 발생

### My Code
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] output = new int[temperatures.length];
        Deque<Integer> tempStack = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){
            if(tempStack.isEmpty()){
                tempStack.push(i);
            }
            while(!tempStack.isEmpty() && temperatures[tempStack.peek()] < temperatures[i]){
                int prevIdx = tempStack.pop();
                output[prevIdx] = i - prevIdx;   
            }
            tempStack.push(i);
        }
        return output;
    }
}
```

중복 논리 부분!
```java
if(tempStack.isEmpty()){
    tempStack.push(i);
}
```

### Polished Code
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] output = new int[temperatures.length];
        Deque<Integer> tempStack = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){
            while(!tempStack.isEmpty() && temperatures[tempStack.peek()] < temperatures[i]){
                int prevIdx = tempStack.pop();
                output[prevIdx] = i - prevIdx;   
            }
            tempStack.push(i);
        }
        return output;
    }
}
```
// Thu May 14
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int arrayLength = temperatures.length;

        int[] output = new int[arrayLength];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<arrayLength; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIdx = stack.pop();
                output[prevIdx]= i - prevIdx;
            }

            //if(temperatures[i] <= temperatures[stack.peek()]){
            //stack.add(i);
            stack.push(i);
            //}

        }

        return output;

    }
}

// 스택에 뭘 저장하지?
// i==0, 30, stack [0]
// i==1, 38, if temperature[i] > temperatures[stack.peek()]: i-stack.pop() = 1-0 = 1, result[stack.pop()]=1 [1,0,0,0,0,0,0] stack[1]
// i==2, 30, if temperature[i] < temperatures[stack.peek()]: stack.add(temperature[i]), stack[1,2]
// i==3, 36, if temperature[i] > temperatures[stack.peek()]: i-stack.pop() = 3-2 = 1, result[stack.pop()]=1 [1,0,1,0,0,0,0] stack[1,3]
// i==4, 35, if temperature[i] < temperatures[stack.peek()]: stack.add(temperature[i]), stack[1,3,4]
// i==5, 40, if temperature[i] > temperatures[stack.peek()]: i-stack.pop() = 5-4 = 1, result[stack.pop()]=1 [1,0,1,0,1,0,0] stack[1,3]
//           if temperature[i] > temperatures[stack.peek()]: i-stack.pop() = 5-3 = 2, result[stack.pop()]=2 [1,0,1,2,1,0,0] stack[1]
//           if temperature[i] > temperatures[stack.peek()]: i-stack.pop() = 5-1 = 4, result[stack.pop()]=4 [1,4,1,2,1,0,0] stack[]
// i==6, 40, stack[6]
// i==7, 28, if tempeature[i] < temperatures[stack.peek()]: stack.add(temperature[i]), stack[6,7]
// result[stack.pop()] = 0 until stack.isEmpty();
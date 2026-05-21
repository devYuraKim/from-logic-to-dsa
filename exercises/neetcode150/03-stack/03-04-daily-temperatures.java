// Thu May 21 2026
// 41'41'' + LLM feedback
// stack에 온도 저장했다가, index 저장해서 array에서 값 확인하는 방향으로 바꿈
// 마지막에 for loop temperatures.length-1까지 잡아서 off by one error 발생
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] output = new int[temperatures.length];

        Deque<Integer> tempStack = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){

            if(tempStack.isEmpty()){
                tempStack.push(i);
            }

            //i==1 temperatures[0]=30 < temperatures[1]=38:
            // prevIdx = 0
            // output[0] = 1-0
            // stack=[1]
            //i==3 temperatures[2]=30 < temperatures[3]=36;
            // prevIdx = 2
            // output[2] = 3-2 = 1;
            // stack=[1,3]
            //i==5 temperatures[4]=36 < temperatures[5]=40;
            // (1)prevIdx = 4, stack=[1,3]
            // (1)output[4] = 5-4 = 1;
            // (2)prevIdx = 3, stack=[1]
            // (2)output[3] = 5-3 = 2;
            // (3)prevIdx = 1, stack=[]
            // (3)output[1] = 5-1 = 4;
            while(!tempStack.isEmpty() && temperatures[tempStack.peek()] < temperatures[i]){
                int prevIdx = tempStack.pop();
                output[prevIdx] = i - prevIdx;
            }
            tempStack.push(i);

            //i==2 temperatures[1]=38 >= temperatures[2]=30
            // stack=[1,2]
            //i==4 temperatures[3]=36 >= temperatures[4]=35
            // stack=[1,3,4]
            // if(temperatures[tempStack.peek()] >= temperatures[i]){
            //     tempStack.push(i);
            // }

        }

        return output;
    }
}

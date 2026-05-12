// 20'' LLM + Solution Video
// 07'08''
class Solution {

    public int evalRPN(String[] tokens) {

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){

                Integer second = numStack.pop();
                Integer first = numStack.pop();

                Integer result;
                if(token.equals("+")){
                    result = first + second;
                }else if (token.equals("*")){
                    result = first * second;
                }else if (token.equals("-")){
                    result = first - second;
                }else{
                    result = first / second;
                }
                numStack.push(result);

            }else{
                numStack.push(Integer.parseInt(token));
            }
        }

        return numStack.pop();

    }
}
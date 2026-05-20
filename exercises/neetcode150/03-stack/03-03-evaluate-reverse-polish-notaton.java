// Wed May 20 2026
// 8'59''
class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> numStack = new ArrayDeque<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") && numStack.size()>=2){
                Integer after = numStack.pop();
                Integer before = numStack.pop();

                Integer result = 0;

                if(token.equals("+")){
                    result = before+after;
                }
                if(token.equals("-")){
                    result = before-after;
                }
                if(token.equals("*")){
                    result = before*after;
                }
                if(token.equals("/")){
                    result = before/after;
                }

                numStack.push(result);

            }else{
                numStack.push(Integer.parseInt(token));
            }
        }

        return numStack.pop();

    }
}
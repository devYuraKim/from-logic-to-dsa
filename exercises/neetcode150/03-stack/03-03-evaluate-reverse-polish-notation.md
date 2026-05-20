Wed May 20 2026     
8'59''

### Original Code
```java
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
```

### Polished Code (Structural Improvement)

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new ArrayDeque<>();

        for (String token : tokens) {

            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int after = numStack.pop();
                    int before = numStack.pop();
                    int result = 0;

                    if (token.equals("+")) {
                        result = before + after;
                    } else if (token.equals("-")) {
                        result = before - after;
                    } else if (token.equals("*")) {
                        result = before * after;
                    } else if (token.equals("/")) {
                        result = before / after;
                    }

                    numStack.push(result);
                    break;

                default:
                    numStack.push(Integer.parseInt(token));
                    break;
            }
        }

        return numStack.pop();
    }
}
```
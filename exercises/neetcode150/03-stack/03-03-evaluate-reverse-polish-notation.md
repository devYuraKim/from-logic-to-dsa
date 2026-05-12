Tue May 12 2026

### My First Attempt

1. 괄호를 내가 직접 만들어야 하는 줄 알았음
2. 반환 타입에는 맞지 않지만 '수식을 우선 String으로 만들어보자'가 목표였음

=> 20분 고민 후, LLM + Solution 비디오 보다가 '숫자 2개에 연산자 1개'를 보고 바로 코드 짰음.


```java
class Solution {
    public int evalRPN(String[] tokens) {
        
        int length = tokens.length();

        StringBuilder sb = new StringBuilder();

        ArrayDeque<Char> stack = new ArrayDeque<>();

        for(i=0; i<length; i++){
            Char s = tokens.charAt(i);
            if(s.isDigit){
                stack.push(s);
            }else if( s=='+' || s=='-' || s=='*' || s=='/' ){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                    sb.append(s);
                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();

    }
}
```
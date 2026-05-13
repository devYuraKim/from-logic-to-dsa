//10'17''
class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 !=0 ) return false;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }

            // 이 라인이 없어서 "]]"에서 오류남
            if (stack.isEmpty()) return false;

            if(c==')') {
                if(stack.pop() != '(') return false;
            }else if (c=='}'){
                if(stack.pop() != '{') return false;
            }else if (c==']'){
                if(stack.pop() != '[') return false;
            }

        }

        return stack.isEmpty();

    }
}

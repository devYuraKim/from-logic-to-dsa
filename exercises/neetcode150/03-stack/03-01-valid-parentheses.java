//Wed May 20
// 15'11''

class Solution {
    public boolean isValid(String s) {

        if(s.length() % 2 != 0){
            return false;
        }

        Deque<Character> parStack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            char curPar = s.charAt(i);
            if(curPar == '(' || curPar == '{' || curPar == '['){
                parStack.push(curPar);
            }else{
                if(parStack.isEmpty()){
                    return false;
                }else if(curPar == ')' && parStack.pop()!='('){
                    return false;
                }else if(curPar == '}' && parStack.pop()!='{'){
                    return false;
                }else if(curPar == ']' && parStack.pop()!='['){
                    return false;
                }
            }
        }

        return parStack.isEmpty();

    }
}
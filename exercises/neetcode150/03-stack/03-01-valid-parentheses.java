// Approach 1 - [{()}] 이 test case만 보고 코드 작성함
class Solution {
    public boolean isValid(String s) {

        // string에 white space 없다고 가정 (문제 조건 없음)

        // early return condition
        if(s.length() % 2 != 0) return false;

        // set two pointers
        int left = 0;
        int right = s.length() - 1;

        while ( left < right ){
            switch (s.charAt(left)) {
                case '(' -> { if(s.charAt(right) != ')') return false; }
                case '{' -> { if(s.charAt(right) != '}') return false; }
                case '[' -> { if(s.charAt(right) != ']') return false; }
            }
            left++;
            right--;
        }

        return true;
    }
}

// edge case 발생
// (1) '()[]{}'
// (2) '[(){}]'
// (3) '[()]{}'

// Approach 2 - Hint 참고하고 '()[]{}', '[(){}]', '[()]{}' 이 test case만 보고 코드 작성함
// Approach 3 - ']]' 이 test case 보고 stack.peek() == null 추가함
class Solution {
    public boolean isValid(String s) {

        if(s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            switch (s.charAt(i)){
                case ')'-> {
                    // 원래 stack.peek() null check 안 했었음
                    if(stack.peek() == null || stack.peek() != '('){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                case '}'-> {
                    if(stack.peek() == null || stack.peek() != '{'){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                case ']'-> {
                    if(stack.peek() == null || stack.peek() != '['){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}

// edge case 발생
// (1) ']]'
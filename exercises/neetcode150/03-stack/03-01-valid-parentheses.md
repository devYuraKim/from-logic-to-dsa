## 가독성 및 효율성 개선 포인트

### 1. 중복된 `s.charAt(i)` 호출 및 비교 로직 개선
현재 코드는 `if` 문에서 한 번, `switch` 문에서 또 한 번 `s.charAt(i)`를 호출하고 있습니다. 또한 여는 괄호를 `if`에서 검사하고 닫는 괄호를 `switch`에서 검사하므로 가독성이 분산됩니다. 이를 하나의 `switch` 블록으로 통합하는 것이 더 깔끔합니다.

```java
// 현재 코드
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
// ...
```

### 2. 코드 중복 제거 (Don't Repeat Yourself)
각 `case` 내부의 `if (stack.peek() == null || stack.peek() != '...')` 로직이 거의 동일합니다. 이를 하나의 로직으로 합치거나 더 직관적인 방식으로 변경할 수 있습니다.

### 3. 간결한 리턴문
`if(stack.isEmpty()) return true; else return false;`는 단순히 `return stack.isEmpty();`로 줄일 수 있습니다.

---

### 개선된 코드 제안

```java
class Solution {
    public boolean isValid(String s) {
        // 홀수 길이면 절대 유효할 수 없음 (Early Return)
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            switch (c) {
                // 여는 괄호는 모두 스택에 삽입
                case '(', '{', '[' -> stack.push(c);
                
                // 닫는 괄호 처리
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
```

---

### 주요 개선 사항 설명

* **구조 통합:** `if`와 `switch`를 따로 쓰지 않고, 모든 괄호 유형을 하나의 `switch` 안에서 처리했습니다. `case '(', '{', '[' ->` 문법을 사용해 여는 괄호를 한 번에 묶었습니다.
* **`pop()`의 직접 활용:** `peek()`으로 확인하고 다시 `pop()`을 하는 대신, `pop()`을 호출하여 꺼낸 값과 직접 비교했습니다. 코드가 훨씬 간결해집니다.
* **성능:** `s.charAt(i)` 호출 횟수를 최소화(변수 `c`에 저장)하여 미세한 성능 향상을 도모했습니다.
* **가독성:** 마지막 리턴문을 `return stack.isEmpty();`로 작성하여 논리 구조를 명확히 했습니다.



---

### 대안1) HashMap 활용: 확장성 중심
만약 괄호의 종류가 더 늘어날 가능성이 있다면, 짝을 맞추는 정보를 `Map`에 저장하여 `if/case` 문 자체를 없애는 방식도 고려해 볼 수 있습니다.

- 설계 의도: 로직과 데이터를 분리하여, **새로운 종류의 괄호가 추가되어도 본문 코드를 수정하지 않고 Map의 설정만 바꾸도록** 설계되었습니다.
- 장점:
    - 유지보수성:   `if/else`나 `switch`의 복잡한 분기가 사라져 가독성이 높고 코드가 간결합니다.
    - 확장성: 괄호 쌍이 늘어날수록 코드의 복잡도가 증가하지 않습니다.
- 단점:
    - 오버헤드: `Map` 조회, `containsValue()` 탐색 비용 및 `Character` 객체의 오토박싱으로 인해 메모리와 시간 측면에서 비용이 발생합니다.

```java
class Solution {
    // 짝꿍 정보를 상수로 관리 (확장성 용이)
    private static final Map<Character, Character> PAREN_MAP = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (PAREN_MAP.containsValue(c)) {
                // 1. 여는 괄호인 경우 (Map의 value들에 해당)
                stack.push(c);
            } else if (PAREN_MAP.containsKey(c)) {
                // 2. 닫는 괄호인 경우 (Map의 key들에 해당)
                if (stack.isEmpty() || stack.pop() != PAREN_MAP.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```

---

### 대안2) Array 사용 

- 설계 의도: 불필요한 객체 생성을 막고, 조건문의 분기를 최소화하여 런타임을 0ms에 가깝게 단축하는 것입니다.
- 장점:
  - 성능: `char[]` 배열과 기본형(`char`)을 사용하여 힙 메모리 사용을 줄이고 실행 속도를 극대화했습니다.
  - 로직 역전 전략: 삽입 시점에 미리 닫는 괄호를 저장함으로써, 인출 시점에 `stack[top--] != c` 단 한 줄로 검증을 끝내는 영리한 구조를 가집니다.
- 단점:
  - 경직성: 새로운 괄호가 추가되면 `if/else if` 블록을 직접 수정해야 하므로 확장성이 떨어집니다.

```java
class Solution {
public boolean isValid(String s) {
int n = s.length();
if (n % 2 != 0) return false;

        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // 여는 괄호일 때 대응되는 닫는 괄호를 스택에 저장
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '[') {
                stack[++top] = ']';
            } else if (c == '{') {
                stack[++top] = '}';
            } 
            // 닫는 괄호일 때: 스택이 비었거나(top == -1), 
            // 스택에서 꺼낸 '기대값'과 현재 문자 'c'가 다르면 false
            else if (top == -1 || stack[top--] != c) {
                return false;
            }
        }
        
        return top == -1;
    }
}
```
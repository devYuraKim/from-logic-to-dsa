# Root Cause Analysis 01
`PracticeMemoization.java`   
`CorrectionSyntaxMemoization.java`

## 1. Data Structure 선정

**어떤 기준으로 선정해야 하는가?**

> [문제] `memo` 자료구조로 `Array` 대신 `HashMap` 선택
- **원인**: 
    1. 직관적으로 '빠른 검색' -> `HashMap` 선택.
    2. 데이터의 **continuity(연속성)** 및 **density(밀집도)** 고려 없이, 일반적인 key-value lookup에 매몰됨.


- **Fibonacci Sequence의 특성**:
    1. **continuity & density**: key가 0부터 n까지 순서대로 빈틈 없이 채워지는 구조.   
       => `array`의 index 자체가 key 역할.
    2. **fixed range**: `fib(n)`이면 필요한 메모리 공간이 $(n+1)$개로 확정.


- **해결(판단 기준)**:
  1. **key가 정수인가?** ---( no )---> 문자열, 객체 등 `HashMap`   
  2. **key의 range(범위)를 미리 알 수 있나?** ---( no )--->  `HashMap` or `ArrayList`
  3. **데이터가 dense/sparse?**
     - `dense`: `array`(0,1,2처럼 연속됨)
     - `sparse`: `HashMap` (1, 100, 10000처럼 간격이 큼)

    > `HashMap`
    > - key 존재 여부 불확실하거나,
    > - key의 간격이 넓은 (sparse data) 경우 사용.   
     => 해싱 함수 거쳐서 객체를 생성하기 때문에 **오버헤드** 발생

## 2. State, Lifecycle and Scope 

**어느 위치에서 변수를 정의해야 하는가?**

> [문제] 코드 구현 중 `memo`에 값이 누적 저장 되지 않음 발견.   
```java
// ISSUE: dry run 하다가 찾은 거 >> memo가 누적 업데이트가 안 됨
// SOLUTION: ??? 이런 경우에 어떻게 실마리 찾아야 될지를 모르겠는데, 우선 함수 분할 해야 함, 그리고 loop 돌아야 할 듯?
// BRAIN STORMING: n == 4, fib(2) 구함 > 저장. fib(3) 구함 > 저장. fib(4) 구함 > 저장.
// 0부터 n까지 loop 돌아야 할 듯
// ??? 자 여기서 생각 꼬였다. 어떻게 하지? 왜냐면 난 fib(0) = 1, fib(1) = 1을 저장하고 싶거든, 그런데 n == 0이면 loop이 안 돌아
```

- **해결(판단 기준)**: 변수 선언 전에 아래 순서대로 확인.    
    1. **State**: 그 공간에 담긴 **실제 데이터 값**. [무엇을 담는가?]
    2. **Lifecycle**: 데이터가 **유효하게 유지되는 기간**. [언제까지 유효해야 하는가?]
    3. **Scope**: 데이터의 **공간적 경계**. [위 두 조건을 만족하려면 변수를 어디에 선언하는가?]

    > - `recursion(재귀)`: 함수가 반복 호출되므로, `memo`가 외부(전역변수)에 있어야 값이 유지.
    > - `iteration(반복)`: 함수 호출 한 번에서 loop를 돌며 값을 채우므로, `memo`가 내부(지역변수)로 선언됨.


- **적용 예시**:
    1. **State**: 이전에 계산한 fib 값들.
    2. **Lifecycle**: 모든 재귀 호출에 걸쳐 유지되어야 함.
    3. **Scope**: 지역변수 X, parameter로 넘기거나 loop로 전환.


## 3. 반복문 제어 변수($i$)와 종료 조건 상수($n$)

**for loop을 어떻게 통제해야 하는가?**

> [문제] 논리로는 이상 없었으나 실제 코드에서는 `for loop`이 제대로 돌아가지 않아 `null pointer exception` 발생


```java
// ??? 자 여기서 생각 꼬였다. 어떻게 하지? 왜냐면 난 fib(0) = 1, fib(1) = 1을 저장하고 싶거든, 그런데 n == 0이면 loop이 안 돌아
for( int i = 0; i =< n; i++ ){
    // n == 0 한 번 돌아, n == 1 두 번 돌아야 하는데 조기 종료로 한 번만 하고 끝, return 구문 빼버림
    if( n == 0 || n == 1 ) {
        memo.add(n, 1); // { {0:1}, {1:1} }
    }

    // n == 2 세 번 돌아
    int prev_prev = memo.find(n-2); //memo.find(0) == 1
    int prev = memo.find(n-1); //memo.find(1) == 1;
    memo.add(n, prev_prev + prev); // { {0:1}, {1:1}, {2:2} }

    // n == 3 네 번 돌아
    // n == 2에서 early return이 되어 버리지 않게 return loop에서 빼버림
    // int prev_prev = memo.find(1) == 1
    // int prev = memo.find(2) == 2
    // memo.add(3, 3); // { {0:1}, {1:1}, {2:2}, {3:3} }
}
```

- **원인1**: **변수**($i$, 현재 단계)와 **상수**($n$, 종료 조건)을 혼동.   
  머릿속으로는 $n=4$일 때의 시뮬레이션, 코드에도 루프 변수 $i$ 대신 머릿속의 숫자 $n$을 그대로 적어버림.


- **해결1**: **상수 격리**.    
루프 내부에서 $n$은 오직 `언제 멈출 것인가`를 결정하는 비교문($i <= n$)에서만 사용. 그 외의 모든 인덱스 접근은 반드시 $i$ 기준 수행.


- **원인2**: 경계 조건 미구분.    
  루프를 짤 때 `n번 반복한다`는 관습에 갇혀 $i < n$으로 설정함. 피보나치는 $0$부터 $n$까지 총 $(n+1)$개의 좌표가 필요함. $i < n$으로 쓰면 정작 최종 결과값이 담길 `memo[n]`에는 도달하지 못한 채 루프가 종료됨.


- **해결2**: **좌표 일치**.    
구하고자 하는 값이 $n$번째 인덱스라면, 루프 조건식은 반드시 $i <= n$이 되어야 함을 명시.

    > -  $n$을 "반복 횟수"로 읽으면 `i < n`    
    > - "마지막 index"로 읽으면 `i <= n`    
 fib($n$)에서 $n$은 index이므로 `i <= n`


## 4. Static Setting vs Dynamic Loop

**for loop을 i == 0부터 시작해야 한다는 고정 관념 버리기**

> [문제] 루프 내부에서 `if(n == 0 || n == 1)`을 매번 검사하며 초기값을 넣으려 함.

- **원인**: '**반복되지 않는 시작점(Static)**'과 '**반복되는 규칙(Dynamic)**'을 하나의 루프에 통합.


- **해결**: **역할 분리**.
  1. **Static Setting (루프 밖)**: $fib(0), fib(1)$ 등 이미 알고 있는 값은 루프 밖에서 미리 `memo`에 직접 할당.
  2. **Dynamic Loop (루프 내)**: 루프 변수 $i$의 시작점을 규칙이 처음 적용되는 지점(예: $i=2$)으로 설정, 루프 안에서는 if문 없이 순수 연산만 수행.


## 5. Guard Clause vs Base Case

> [문제] 루프 내부에서 `if(n == 0 || n == 1)`을 검사하며 `early return`을 고민함.

- **원인1**: **패턴 혼동**. 
    Guard Clause(early return pattern)와 Base Case(recursive pattern)을 혼동.


- **원인2**: **방향성 충돌**.      
재귀의 직관(Top-Down, $n \to 0$)과 반복문의 효율(Bottom-Up, $0 \to n$)이 머릿속에서 충돌.
    > - 재귀는 $fib(n)$을 호출하면 $fib(n-1)$로 내려감.     
  > - 반복은 $0$부터 $n$으로 올라감.


- **해결**: 개념 분리.

### 1. Guard Clause - Iteration, Bottom Up
- **Purpose**: 유효하지 않은 데이터나 특수 케이스가 **메인 로직을 오염시키는 것을 방지**. 중첩 if문을 제거하여 코드의 가독성(Clean Code) 확보.      
- **Action**: 입력값이 실행 조건을 충족하지 않을 경우, **로직 시작 전 즉시 종료**(Return/Throw/Continue).
- **Location**: **함수/메서드의 최상단**. 어떠한 변수 초기화나 리소스 할당보다 먼저 실행됨.

    ```java
    public static int fib(int n) {
        if (n <= 1) return 1; // Guard Clause
        
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);

        for (int i = 2; i <= n; i++) {
            int val = memo.get(i - 1) + memo.get(i - 2);
            memo.put(i, val);
        }
  
        return memo.get(n);
    }
    // 반복문/함수 최상단에서 불필요 계산 차단.
    ```

### 2. Base Case - Recursion, Top Down  
- **Purpose**: 재귀 호출의 **무한 루프 방지** 및 스택 프레임의 **역추적**(Unwinding) 시작점 제공.   
- **Action**: 문제가 더 이상 쪼개질 수 없는 **최소 단위**(Atomic Size)에 도달했을 때, 추가 호출 없이 즉시 **기저값**(Base Value)을 반환.    
- **Location**: **재귀 로직 직전**. 자기 자신을 다시 호출하기 전에 반드시 체크되어야 함.
 
  ```java
    public static int factorial(int n) {
        if (n <= 1) return 1; // Base Case
        return n * factorial(n - 1);
    }
    // "더 이상 쪼갤 수 없는 가장 작은 문제"에 도달했을 때 
    // 함수를 끝내고 값을 위로 던져주는 역할.
  ```
---

## * RCA 최종 요약 (Self-Check 용)
1. **DS (Data Structure)**: 데이터가 연속적인 정수 인덱스인가?
    * **Yes** $\rightarrow$ **Array** (공간 확정성 및 조회 성능 최적화)
    * **No** $\rightarrow$ **HashMap** (비연속적/희소 데이터 대응)

2. **Scope & Lifecycle**: 데이터가 필요한 수명(Lifetime)만큼 살아있는가?
    * **재귀(Recursive)** $\rightarrow$ 함수 외부(전역) 혹은 파라미터로 전달하여 상태 유지
    * **반복(Iterative)** $\rightarrow$ 함수 최상단 선언으로 루프 내 누적 업데이트 보장

3. **Variable (상수 격리)**: 루프 인덱스로 목표치($n$)가 아닌 증감 변수($i$)를 쓰고 있는가?
    * $n$은 오직 **종료 조건**으로만 사용하고, 모든 내부 연산은 **현재 단계인 $i$**를 기준으로 수행

4. **Boundary (좌표 일치)**: 목표한 $n$번 인덱스까지 정확히 도달하는가?
    * **반복 횟수**가 아닌 **최종 목적지 인덱스**를 기준으로 조건식 설정 ($i \le n$)

5. **Initialization (Static Setting)**: 반복되지 않는 초기값은 루프 밖으로 뺐는가?
    * $fib(0), fib(1)$ 등 기저 사실은 루프 진입 전 미리 할당하여 루프 내 불필요한 `if`문 제거

6. **Early Return (역할 분리)**: 지금 쓰려는 리턴이 '입구 컷'인가 '종착역'인가?
    * **Guard Clause**: 함수 최상단에서 부적격 데이터 차단 (가독성/효율)
    * **Base Case**: 재귀의 바닥을 찍고 올라오기 위한 신호 (재귀 종료)
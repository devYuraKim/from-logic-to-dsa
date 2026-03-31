02-partition-equal-subset-sum

# Fibonacci Sequence + Dynamic Programming

- DP(Dynamic Programming)를 직관적으로 이해하기 위해 피보나치 수열 문제를 단계별로 구현

- 중복 계산 → 메모이제이션 → 반복문 최적화 순으로 점진적 최적화 과정을 보여줌

---

[수정] 피보나치로 이해하는 DP의 진화

## 1단계: Brute Force (단순 재귀)
- 코드: `return fib(n-1) + fib(n-2);`
- 특징: 아무런 기록을 하지 않음.
- 문제점: $fib(3)$을 구하기 위해 $fib(2)$를 부르고, $fib(4)$를 구할 때 $fib(2)$를 또 계산함. 이처럼 중복 계산이 기하급수적으로 늘어나 $n$이 조금만 커져도 시스템이 멈춤 ($O(2^n)$).

```java
public class Step1 {
    
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        // [특징] 아무런 기록 장치가 없음
        if (n <= 1) return 1;
        
        // [문제점] fib(n-1)을 구할 때 했던 계산을 fib(n-2)에서 또 함 (중복 계산)
        // n이 커지면 기하급수적으로 느려짐 (O(2^n))
        return fib(n - 1) + fib(n - 2);
    }
}
```

## 2단계: Recursion + Memoization (Top-Down DP)
- 코드: `if (memo[n] != 0) return memo[n];` + 재귀 호출
- 특징: 위($n$)에서 아래($0$)로 내려가며, 처음 구한 값은 메모장(memo[])에 기록함.
- 한계: 논리는 완벽하지만, 자바 구조상 함수 호출 시 Stack 영역을 계속 파고들기 때문에 $n$이 너무 크면 `StackOverflow` Error가 발생함.

```java
public class Step2 {
// [특징] 계산 결과를 저장할 메모장(Array) 도입
    
    private static int[] memo = new int[100];

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 1) return 1;

        // [핵심] 이미 계산한 적이 있다면 즉시 반환 (조회 성능 O(1))
        if (memo[n] != 0) return memo[n];

        // 계산 후 메모장에 기록 (재귀적으로 내려감)
        memo[n] = fib(n - 1) + fib(n - 2);
        
        // [한계] n이 10,000처럼 커지면 StackOverflowError 발생 (자바 스택의 한계)
        return memo[n];
    }
}
```

## 3단계: Iteration + Memoization (Bottom-Up DP)
- 코드: `for (int i = 2; i <= n; i++) { memo[i] = memo[i-1] + memo[i-2]; }`
- 특징: 아래($0, 1$)부터 위($n$)로 차근차근 표(Table)를 채워나감. (Tabulation)
- 결과: 가장 안전하고 빠름. 반복문을 사용하므로 스택이 터질 위험이 없고, 모든 값을 딱 한 번씩만 계산함 ($O(n)$).

```java
public class Step3 {
    private static int[] memo = new int[0];

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 1) return 1;

        // [진화 1] 동적 배열 확장 (안정성)
        if (n >= memo.length) {
            int[] newMemo = new int[n + 1];
            System.arraycopy(memo, 0, newMemo, 0, memo.length);
            memo = newMemo;
            memo[0] = 1; memo[1] = 1;
        }

        // [진화 2] 이미 있다면 루프 없이 즉시 반환
        if (memo[n] != 0) return memo[n];

        // [진화 3] 반복문을 통해 아래에서 위로 차근차근 표를 채움 (Tabulation)
        // 스택을 쌓지 않으므로 절대 터지지 않음 (O(n))
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n];
    }
}
```

## 4단계: Space Optimization (변수 2개)
- 코드: `int prev = 1, curr = 1;`
- 특징: 어차피 직전 두 값만 있으면 다음 값을 구할 수 있음 → 배열 전체 불필요
- 결과: 공간복잡도 $O(n)$ → $O(1)$
```java
public class Step4 {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 1) return 1;
        int prev = 1, curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
```


---

[수정 전]

### 1단계: 단순 재귀 (중복 계산 발생)

```java
int fib(int n) {
    if (n <= 1) return 1;
    return fib(n-1) + fib(n-2); // fib(3)을 두 번 부름
}
```

> - n이 커질수록 같은 값(fib(3), fib(2) 등)을 여러 번 계산 → 계산량 2^n 급증
> - 스택 메모리도 계속 쌓임 → n이 너무 크면 StackOverflow 가능

즉, 시간과 메모리 둘 다 비효율적

### 2단계: 재귀 + 메모이제이션 (중복 계산 제거)

```java
int[] memo = new int[100]; // 메모장

int fib(int n) {
    if (n <= 1) return 1;
    if (memo[n] != 0) return memo[n]; // 이미 적혀 있으면 꺼내 쓰기
    memo[n] = fib(n-1) + fib(n-2);   // 없으면 계산하고 적기
    return memo[n];
}
```

- 이미 계산한 값을 배열(memo)에 저장 → 중복 계산 제거
- 시간복잡도 $O(2^n)$ → $O(n)$
- 단, 재귀 구조는 유지 → StackOverflow 위험 여전히 존재

### 3단계: 반복문 + 메모이제이션 (스택 위험 제거)

```java
int[] memo = new int[100]; // 메모장

int fib(int n) {
    if (n <= 1) return 1;
    if (memo[n] != 0) return memo[n]; // 이미 적혀 있으면 꺼내 쓰기
    for (int i = 2; i <= n; i++) {
        memo[i] = memo[i - 2] + memo[i - 1];
    }
    return memo[n];
}
```

- 재귀 호출을 반복문으로 교체 → StackOverflow 위험 제거
- memo 배열은 그대로 유지 → 공간복잡도 $O(n)$

### 4단계: 반복문 + 변수 2개 (공간 최적화)

```java
int fib(int n) {
    if (n <= 1) return 1;
    int prev = 1, curr = 1;
    
    for (int i = 2; i <= n; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}
```
- 핵심: 이전 두 값(prev, curr)만 기억하면 됨, 배열 불필요 → 메모리와 시간 효율 최적화
- 공간복잡도 $O(n)$ → $O(1)$


02-partition-equal-subset-sum

# Fibonacci Sequence + Dynamic Programming

- DP(Dynamic Programming)를 직관적으로 이해하기 위해 피보나치 수열 문제를 단계별로 구현

- 중복 계산 → 메모이제이션 → 반복문 최적화 순으로 점진적 최적화 과정을 보여줌

---

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

### 2단계: 메모이제이션 (이미 계산한 값 저장)

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

- 핵심 DP 아이디어 구현: 작은 문제의 결과를 재활용

### 3단계: 반복문으로 최적화 (재귀 제거)

```java
int fib(int n) {
    int prev = 1, curr = 1;
    for (int i = 2; i <= n; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}
```

- 재귀를 반복문으로 바꾸어 메모리와 시간 효율 최적화

- 핵심: 이전 두 값(prev, curr)만 기억하면 됨

- DP의 “작은 문제 답 저장 후 재활용” 개념을 직관적으로 체감 가능

> - 중복 계산 없음: fib(3)나 fib(2)를 다시 계산하지 않음
> - 필요한 값만 저장: 이전 두 값(prev, curr)만 기억 → 메모리 사용 O(1)
> - 스택 사용 없음: 재귀 호출 대신 for loop 사용 → StackOverflow 걱정 없음
> - 시간 복잡도 O(n): 재귀는 O(2^n), 반복문은 O(n)

즉, **재귀 → 반복문 변환 = 시간 + 공간 최적화**.

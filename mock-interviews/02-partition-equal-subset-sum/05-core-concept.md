Interviewer Feedback: BackTracking, Fibonacci & Recursion, Memoization

# 1. BackTracking

**핵심**: 가능한 모든 조합/경로를 탐색하면서 조건에 맞는 해를 찾는 방법.

> 오늘 면접에서 "루프로는 안 될 것 같은데 모든 조합을 다 해봐야 하나?"라고 고민한 그 지점의 해답.

- **실체**: 가볼 수 있는 길을 끝까지 가보고, 답이 아니면 다시 돌아와서(Back) 다른 길을 찾는 '**전수 조사**' 기법.

- **언제 쓰나**: 모든 경우의 수를 따져야 할 때 (e.g. subset, 순열, 조합)

- **시간복잡도**: $O(2^n)$ — 그래서 Memoization이 필요해짐

- **오늘 문제와의 연결**: Subset Sum에서 숫자들을 넣었다 뺐다 하며 모든 조합을 확인하는 과정이 바로 백트래킹. **$2^n$의 시간 복잡도가 나오는 근원**.

---

- Subset Sum 문제에서 나왔던 “**모든 subset을 확인해야 하는 상황**”이 대표적
- 특징:
  - 재귀 구조
  - 각 단계에서 선택/비선택(Include / Exclude)
  - 조건 만족 시 “early return” 가능

- 예제: Subset Sum

  ```java
  boolean canPartition(int[] nums, int target, int index) {
  if (target == 0) return true;          // 성공 종료
  if (index >= nums.length || target < 0) return false;

  // 현재 숫자를 포함하거나 포함하지 않음
  return canPartition(nums, target - nums[index], index + 1) ||
         canPartition(nums, target, index + 1);
  }
  ```

👉 핵심 포인트: **조합 문제를 순서 문제처럼 풀면 안 되고**, 모든 선택지를 재귀로 탐색해야 함.

👉 핵심 포인트: "선택한다"와 "선택하지 않는다"의 **두 갈래 길(Binary Tree)이 모여 $2^n$ 생성**. 복잡할 것 없이 가능한 경우의 수임. 조합임.

# 2. Fibonacci & Recursion (end condition & recursion calling)

**핵심**: 재귀를 사용할 때 “종료 조건(End Condition)”과 “재귀 호출(Recursive Call)” 구조를 명확히 해야 함

- Fibonacci는 대표적인 단순 재귀 구조

- 종료 조건:
  **재귀의 생명줄**. if (i == 0 || i == 1) 같은 조건이 **없으면 무한루프**. **Stack overflow 주의**.

  ```java
  int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
      return fib(n-1) + fib(n-2);
  }
  ```

# 3. Memoization

**핵심**: 재귀 계산에서 이미 계산한 값을 저장해 중복 계산을 피함 → DP의 시작 단계

- **언제 쓰나**: 같은 계산이 반복될 때 (Recursion의 단점 보완)

- **오늘 연결**: React의 `useMemo`, `useCallback`과 같은 개념

- **시간복잡도**: $O(2^n)$ → $O(n)$으로 줄어듦

- Fibonacci 예제 + Memoization:

  ```java
  int fib(int n, int[] memo) {
  if (n == 0 || n == 1) return n;
  if (memo[n] != -1) return memo[n];   // 이미 계산된 값 사용
  memo[n] = fib(n-1, memo) + fib(n-2, memo);
  return memo[n];
  }

    // 호출 예시
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    fib(n, memo);
  ```

# 4. 연결

1. **Backtracking** → 모든 경우의 수 확인
2. **Recursion (Fibonacci 패턴)** → 재귀 구조 + 종료 조건 관리
3. **Memoization** → 이미 계산한 상태 저장 → 시간복잡도 개선

   즉, **Subset Sum** 문제를 제대로 풀려면:

- 먼저 Backtracking ($2^n$) → 너무 느림
- Recursion으로 구현
- 이미 계산한 상태는 Memoization으로 재사용하여 최적화
- DP로 발전

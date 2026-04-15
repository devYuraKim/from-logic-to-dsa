코드 잘 읽었어요! 사고 과정이 꽤 좋아요. 피드백 드릴게요.

---

**1. 바로 고쳐야 할 것 - `map.put(nums[i])`**

`put`은 key, value 두 개가 필요해요. value가 딱히 의미 없으면 보통 이렇게 써요:
```java
map.put(nums[i], 1);  // value는 아무 값이나
```

근데 사실 이 경우엔 `HashMap` 말고 **`HashSet`이 더 적합해요:**
```java
Set<Integer> set = new HashSet<>();
if(!set.add(nums[i])) return true;  // add가 false면 이미 있다는 뜻
```

---

**2. 세 가지 방식 비교 - 코멘트에 적어두신 거**

| 방식 | 시간복잡도 | 공간복잡도 |
|------|-----------|-----------|
| Sort + loop | O(n log n) | O(1) |
| HashMap/HashSet | O(n) | O(n) |
| XOR | ❌ 이 문제엔 안 맞아요 |

XOR은 **모든 숫자가 1~n 범위**일 때 하나의 중복을 찾는 트릭인데, 이 문제는 그 조건이 없어요.

---

>XOR는 왜 하면 안 돼?
저거 loop through하면서 XOR 시켜서 false 나오는 순간 Duplicate value 있는 거 아냐?


XOR 특성을 다시 생각해봐요!

```
1 XOR 1 = 0  (같으면 0)
1 XOR 0 = 1  (다르면 1)
```

문제는 **XOR은 누적이라서 순서랑 조합에 따라 결과가 달라져요:**

```
[1, 2, 3, 1] 이면
1 XOR 2 = 3
3 XOR 3 = 0
0 XOR 1 = 1  → 결과: 1
```

```
[1, 2, 1, 2] 이면
1 XOR 2 = 3
3 XOR 1 = 2
2 XOR 2 = 0  → 결과: 0
```

둘 다 duplicate가 있는데 결과가 달라요. 그래서 XOR 결과값만으로는 **"duplicate가 있다/없다"를 판단할 수가 없어요.**

XOR이 통하는 건 **"1~n 숫자 중 딱 하나만 빠졌을 때"** 같은 아주 특정한 조건일 때예요.

---

## 최종 정리

네 맞아요, XOR도 결국 loop은 해야 해요.

**이 문제 최적 풀이는 HashSet이에요:**

```java
Set<Integer> set = new HashSet<>();
for(int num : nums) {
    if(!set.add(num)) return true;  // add가 false면 이미 있다는 뜻
}
return false;
```

| 방식 | 시간복잡도 | 공간복잡도 |
|------|-----------|-----------|
| Sort + loop | O(n log n) | O(1) |
| HashMap | O(n) | O(n) |
| **HashSet** | **O(n)** | **O(n)** |

HashMap이랑 시간/공간복잡도는 같은데, 어차피 value가 필요 없으니까 HashSet이 더 깔끔해요.

공간을 아끼고 싶으면 Sort + loop, 속도를 아끼고 싶으면 HashSet이에요!

---

## HashMap / HashSet 주요 메소드

| | HashMap | HashSet |
|---|---|---|
| 추가 | `map.put(k, v)` | `set.add(v)` |
| 조회 | `map.get(k)` | `set.contains(v)` |
| 존재확인 | `map.containsKey(k)` | `set.contains(v)` |
| 삭제 | `map.remove(k)` | `set.remove(v)` |
| 크기 | `map.size()` | `set.size()` |
| 비어있는지 | `map.isEmpty()` | `set.isEmpty()` |
| 기본값 조회 | `map.getOrDefault(k, 0)` | - |


> 왜 메소드가 다 달라.. 너무 짜증나.. 

ㅋㅋㅋㅋ 맞아요 처음엔 진짜 짜증나죠!   
근데 이렇게 생각하면 좀 나아요:

- **HashSet**은 `value`만 있으니까 `add`, `contains`로 단순
- **HashMap**은 `key-value` 쌍이니까 `put`, `get`, `containsKey`로 구분
---
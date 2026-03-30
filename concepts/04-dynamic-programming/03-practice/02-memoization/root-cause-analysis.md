# Root Cause Analysis

## 1. DS 선정 기준
> `memo` 자료구조로 `Array` 대신 `HashMap` 선택
- **현상**: 직관적으로 '빠른 검색' -> `HashMap` 선택
- **원인**: 데이터의 `continuity(연속성)`과 `density(밀집도)` 고려 없이, 일반적인 `key-value lookup`에 매몰됨.
- **checklist**:
    1. **`key`가 정수인가?** --`no`--> 문자열, 객체 등 `HashMap`   
    2. **`key`의 range(범위)를 미리 알 수 있나?** --`no`-->  `HashMap` or `ArrayList`
  3. **데이터가 `dense` or `sparse`?**
     - `dense`: `array`(0,1,2처럼 연속됨)
     - `sparse`: `HashMap` (1, 100, 10000처럼 간격이 큼)

## 2. Scope/State 
> `memo`에 값이 누적 저장 되지 않음

## 3. 반복문 제어 변수($i$)와 입력값($n$)
> 논리로는 완벽했는데 실제 코드에서는 `for loop`이 제대로 돌아가지 않아 `null pointer exception` 발생
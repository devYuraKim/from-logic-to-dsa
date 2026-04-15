코멘트에 정리하신 거 맞아요! 하나씩 설명할게요.

---

**1. Array vs List 차이**

| | Array | ArrayList |
|---|---|---|
| 크기 | 고정 (`int[] arr = new int[5]`) | 가변 (자동으로 늘어남) |
| 접근 | `arr[i]` | `list.get(i)` |
| 할당 | `arr[i] = value` | `list.set(i, value)` |
| 추가 | 불가 | `list.add(value)` |
| 타입 | primitive 가능 (`int`, `char`...) | 객체만 (`Integer`, `String`...) |

---

**2. add / get**

```java
list.add(value)        // 맨 뒤에 추가
list.add(index, value) // 특정 위치에 삽입 (기존 요소 밀림, 비어있으면 에러)
list.get(index)        // 읽기
list.set(index, value) // 덮어쓰기 (요소가 이미 있어야 함)
list.size()            // 길이
```

---

**3. if-else 논리 — FizzBuzz 조건 순서**

```java
// ❌ 지금 코드: 각 조건에서 두 가지를 다 체크
i % 3 == 0 && i % 5 != 0
i % 5 == 0 && i % 3 != 0

// ✅ FizzBuzz를 먼저 체크하면 나머지는 하나만 체크해도 됨
if (i % 3 == 0 && i % 5 == 0)  // FizzBuzz 먼저
else if (i % 3 == 0)             // 여기 오면 이미 % 5 != 0 확정
else if (i % 5 == 0)             // 여기 오면 이미 % 3 != 0 확정
```

---

**4. Short Circuit (`&&`, `||`)**

`&&`는 앞이 `false`면 뒤를 **아예 평가 안 해요.**
`||`는 앞이 `true`면 뒤를 **아예 평가 안 해요.**

```java
// list가 null이면 두 번째 조건은 실행 안 됨 → NullPointerException 방지
if (list != null && list.size() > 0)

// 조건 순서를 잘 짜면 불필요한 연산을 줄일 수 있음
```

---

여기서 한 번 터졌었거든?


```java
class Solution {

    public List<String> fizzBuzz(int n) {
        
        List<String> resultList = new ArrayList<>();

        for(int i=1; i<=n; i++){

            // 3,5 공배수는 더 깔끔하게 할 수 있을 것 같은데?
            if(i % 3 == 0 && i % 5 != 0) {
                // resultList[i] = "Fizz";
                resultList.set(i, "Fizz");
            }else if(i % 5 == 0 && i % 3 != 0){
                // resultList[i] = "Buzz";
                resultList.set(i, "Buzz");
            }else if (i % 5 == 0 && i % 3 == 0){
                // resultList[i] = "FizzBuzz";
                resultList.set(i, "FizzBuzz");
            } else {
                // 이거 as a String 어떻게 해?
                // resultList[i] = i;
                resultList.set(i, String.valueOf(i));
            }
        }

        return resultList;

    }
}
```


여기서 계속 OutOfBounds issue가 생겼어
이거 내가 뭘 놓친 거야?

`set` 때문이에요! 아까 설명한 것과 같은 문제예요.

`set`은 **이미 있는 요소를 덮어쓰는** 거라, 리스트가 비어있으면 터져요.

```java
List<String> list = new ArrayList<>();
list.set(0, "hello"); // ❌ 비어있으니까 터짐

list.add("hello");    // ✅ 이렇게 먼저 채워야 함
list.set(0, "world"); // ✅ 이제 덮어쓰기 가능
```

이 코드에서는 루프를 돌면서 계속 **빈 리스트에 set을 시도**하고 있었던 거예요. `add`로 바꾸면 해결돼요!
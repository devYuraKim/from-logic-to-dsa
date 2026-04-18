**Array**, **HashMap**, **String**

### Array

- Time complexity: $O(n)$
- Space complexity: $O(1)$ (fixed 26 integers)
- **dense**, **small range**, **predictable**: e.g. alphabet(lowercase/uppercase) `int[26]` or `int[52]`


```java
int[] count = new int[26];

for(char c : s.toCharArray())
count[c - 'a']++;

        for(char c : t.toCharArray()) {
count[c - 'a']--;

        if(count[c - 'a'] < 0)
        return false;
        }

        return true;
```

### HashMap

- Time complexity: $O(n)$
- Space complexity: $O(k)$ ($O(1) if alphabet is fixed)
- - **sparse**, **large range**, **unpredictable**: e.g. all Unicode characters

```java
public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;

    Map<Character, Integer> map = new HashMap<>();

    for(char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for(char c : t.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) - 1);
        if(map.get(c) < 0) return false;
    }

    return true;
}
```

---

# HashMap 주요 메서드 요약

이 코드에서 사용된 `Map` 인터페이스의 주요 메서드 4가지에 대한 기능 정리입니다.

| 메서드 | 기능 설명                          | 사용 예시 |
|:---|:-------------------------------|:---|
| **`containsKey(k)`** | 특정 key 포함 여부 확인                | 존재하면 `true`, 없으면 `false` 반환 |
| **`put(k, v)`** | 맵에 key-value 쌍 저장              | 동일 키가 있으면 기존 값을 덮어씀 |
| **`get(k)`** | 매핑된 값 반환                       | 키가 존재하지 않으면 `null` 반환 |
| **`getOrDefault(k, d)`** | 키(`k`) 찾고, 없으면 기본값(`d`) 반환     | `null` 처리 로직을 줄일 때 유용함 |

---

# String sort 주의점

### TRY 1

> String은 Array처럼 바로 Arrays.sort()이 안 된다길래 이렇게 썼었는데 안 된다길래 바꿨거든?

```java
        String sortedS = new String(Arrays.sort(s.toCharArray()));
        String sortedT = new String(Arrays.sort(t.toCharArray()));
        if(sortedS.equals(sortedT)) { 
            return true ;
        } else {
            return false;
        }
```

해당 코드가 컴파일되지 않았던 이유는 **`Arrays.sort()`의 반환 타입** 때문입니다.

### 1. `void`는 값으로 쓸 수 없습니다
`Arrays.sort()` 메서드의 정의를 보면 반환 타입이 `void`입니다.

* **`void`의 의미**: "이 메서드는 작업을 수행할 뿐, 아무것도 돌려주지 않는다"는 뜻입니다.
* **문제의 원인**: `new String(...)`의 괄호 안에는 문자 배열(`char[]`)이 들어와야 합니다. 하지만 `Arrays.sort()`는 아무것도 반환하지 않기 때문에, 자바 입장에서는 `new String(void)`라는 말도 안 되는 코드를 실행하려 한 셈이 됩니다.

### 2. 실행 순서의 오류
작성하려 했던 코드의 의도는 다음과 같았을 것입니다.
1. `s.toCharArray()`로 배열 생성
2. 그 배열을 정렬
3. 정렬된 배열을 `new String()`에 전달

하지만 Java에서 메서드 중첩은 **안쪽부터 값을 반환하며** 밖으로 나옵니다. `Arrays.sort()`가 배열을 정렬한 뒤 그 배열을 다시 밖으로 던져주지(return) 않기 때문에 연결이 끊긴 것입니다.

---

### 정석적인 수정 방향
정렬된 배열을 `String`으로 만들려면 반드시 **변수에 담아 정렬하는 중간 단계**가 필요합니다.

```java
char[] charsS = s.toCharArray(); // 1. 배열 생성
Arrays.sort(charsS);             // 2. 배열 정렬 (반환값 없음, charsS 자체를 변경)
String sortedS = new String(charsS); // 3. 정렬된 배열로 새 문자열 생성
```

### 요약하자면
* **잘못된 생각**: `Arrays.sort(배열)`이 "정렬된 배열"을 결과물로 줄 것이다.
* **실제 동작**: `Arrays.sort(배열)`은 원본 배열의 내부만 휘젓고 끝난다. 결과물(`return`)은 **없다(void)**.

이 차이 때문에 한 줄로 합쳐서 쓰는 것이 불가능했던 것입니다.

---

### TRY 2
제시하신 코드와 고민 내용에서 핵심이 되는 기술적 포인트는 크게 세 가지입니다. `String`의 불변성(Immutability), `sort` 메서드의 부재, 그리고 데이터 타입의 변환 과정입니다.

### 1. `String`은 정렬할 수 있는 메서드가 없다
Java의 `String` 클래스 내부에는 `sort()`라는 인스턴스 메서드가 존재하지 않습니다. 따라서 `s.sort()`와 같은 방식은 문법적으로 불가능합니다.
* **이유**: `String`은 한 번 생성되면 그 값을 변경할 수 없는 **불변(Immutable)** 객체이기 때문입니다.
* **해결**: 정렬을 하려면 변경이 가능한 `char[]`(문자 배열)로 변환하거나, `StringBuilder` 등을 사용해야 합니다.

### 2. `Arrays.sort()`의 반환값 (Void)
`Arrays.sort()` 메서드는 원본 배열 자체를 수정(In-place)하며, 반환값이 없습니다(`void`).
* **놓친 포인트**: `String sortedS = Arrays.sort(charsS);`와 같이 작성할 수 없습니다.
* **작동 방식**: `Arrays.sort(charsS);`를 실행하면 `charsS`라는 배열의 내부 순서가 물리적으로 바뀝니다. 그 후 이 배열을 다시 `String`으로 조립해야 합니다.

### 3. 배열과 문자열의 메모리 구조 차이
배열은 내부 요소의 위치를 직접 바꿀 수 있는 메모리 구조를 가지지만, 문자열은 그렇지 않습니다.

| 구분 | `char[]` (배열) | `String` (문자열) |
| :--- | :--- | :--- |
| **변경 가능성** | 가변 (Mutable) | 불변 (Immutable) |
| **정렬 방법** | `Arrays.sort()` 사용 가능 | 직접 정렬 불가 (배열 변환 필요) |
| **메모리** | 기존 공간의 데이터 위치 변경 | 정렬된 결과를 담은 **새로운 객체** 생성 필요 |

---

### 요약: 작업 흐름의 필연성
본인이 작성하신 주석 처리된 코드가 정석적인 절차를 밟고 있는 이유는 다음과 같습니다.

1.  **변환**: `s.toCharArray()` (수정이 불가능한 String을 수정 가능한 배열로 복사)
2.  **정렬**: `Arrays.sort()` (배열 내부의 순서를 바꿈)
3.  **재조립**: `new String(charsS)` (정렬된 배열을 기반으로 **새로운** String 객체 생성)

결과적으로 `String`은 스스로를 바꿀 수 없기 때문에, "새로운 변수에 할당"하거나 최소한 "새로운 객체를 생성"하여 비교하는 과정이 반드시 필요합니다.
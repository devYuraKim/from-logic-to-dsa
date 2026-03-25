## **Array List** vs **Linked List**

### **I. Memory Layout**

The core difference: **physical adjacency**.

- **Array List**: **Peas in a pod** 느낌.

  > **요소들이 빈틈없이 단일 메모리 블록** 점유.  
  > 일정한 간격으로 배치되어 있어 **시작점 계산만으로 특정 위치 직접 접근 가능**.

  Occupies a **contiguous** block of memory.  
  This allows the CPU to use "Random Acess" to **jump to any index instantly** using a simple math formula: $Address = Base + (Index * Size)$

- **Linked List**: **Scavenger hunt** 느낌.

  > **노드들이 메모리 내 가용 공간에 파편화**되어 존재.  
  > 각 노드가 독립적이어서, **오직 다음 노드의 위치 정보(pointer)를 통해서만 연결** 가능. 중간 요소를 찾으려면 반드시 첫 번째 노드(head)부터 시작해서 하나씩 추적해야 함.

  Occupies **incontiguous** memory.  
  Each element(**node**) is stored wherever there is free space. Each node must store **the data plus a pointer(the address) to the next node**.  
  **You cannot "jump" to the middle; you must follow the breadcrumbs from the start(Head)**.

| 구분            | Array List                     | Linked List               |
| :-------------- | :----------------------------- | :------------------------ |
| **물리적 배치** | 연속적 (Contiguous)            | 분산됨 (Incontiguous)     |
| **탐색 방식**   | 인덱스 기반 직접 접근 ($O(1)$) | 순차적 접근 ($O(n)$)      |
| **데이터 관계** | 논리적 순서 = 물리적 순서      | 포인터를 통한 논리적 연결 |

---

### **II. Structure**

Linked List는 물리적 연속성을 포기, 대신 참조(reference) 사용.

### 1) Node 기본 구성 (Data + Pointer)

- **Data**: 노드가 저장하는 실제 값.
- **Pointer (Next)**: 다음 노드의 메모리 주소를 가리키는 참조.

### 2) List-Level Pointers

- **Head**: 리스트의 첫 번째 노드를 가리키는 포인터 -> 리스트에 접근하는 시작점.
- **Tail**: 리스트의 마지막 노드를 가리키는 포인터 -> 마지막 노드의 next 포인터는 `null`을 가리킴.

---

### **III. Next와 Head/Tail의 차이**

0. 둘 다 **포인터**
1. **`Next`**: 노드 간 연결을 위한 **내부 포인터**
2. **`Head/Tail`**: 리스트에 접근하기 위한 **외부 포인터**

### 1) Next

- 노드 내부에 있는 포인터
- **다음 노드**를 가리킴

```text
[ data | next ] -> [ data | next ] -> null
```

### 2) Head / Tail

- 리스트를 관리하기 위한 외부 포인터
- 노드 밖에서 리스트를 가리킴
  - Head: **첫 번째 노드**를 가리킴
  - Tail: **마지막 노드**를 가리킴

```text
      Head
       ↓
[ data | next ] -> ... -> [ data | next ] -> null
                                 ↑
                                Tail
```

---

### **IV. 데이터 구조**

$Node = Value + Pointer$

```java
[ head ]                                  [ tail ]
   ↓                                         ↓
[ 11 ] --> [ 3 ] --> [ 23 ] -->  [ 7 ] --> [ 4 ] -null->
```

```java
head = {
        "value" = 11,
        "next" = {
                "value" = 3,
                "next" = {
                        "value" = 23,
                        "next" = {
                                "value" = 7,
                                "next" = {
                                        "value" = 4,
                                        "next" = null
tail ---------------------------------> }
                                }
                        }
                }
        }
```

---

### **V. Big O 비교**

| Process             | Linked List | Array List |
| :------------------ | :---------- | :--------- |
| Append              | $O(1)$      | $O(1)$     |
| **Remove Last**     | 🟥 $O(n)$   | 🟩 $O(1)$  |
| **PrePend**         | 🟩 $O(1)$   | 🟥 $O(n)$  |
| **Remove First**    | 🟩 $O(1)$   | 🟥 $O(n)$  |
| Insert              | $O(n)$      | $O(n)$     |
| Remove              | $O(n)$      | $O(n)$     |
| **Lookup by Index** | 🟥 $O(n)$   | 🟩 $O(1)$  |
| Lookup by Value     | $O(n)$      | $O(n)$     |

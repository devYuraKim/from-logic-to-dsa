### [BigOCheatSheet](https://www.bigocheatsheet.com/)

## **I. Big O = WORST CASE**

- Omega **Ω**: **best**-case
- Theta **Θ**: **average**-case
- Omicron **O**: **worst**-case

Say, from a list: 1, 2, 3, 4, 5, 6, 7

if we go through the elements using a for loop,

- **O (worst-case): 7**
- **Ω (best-case): 1**
- **Θ (average): 4**

therefore, saying '~~_average Big O_~~' or '~~_best-case Big O_~~' doesn't make any sense

## **II. Big O Notation Rules**: '극한(limit)' 개념 생각하면 간단함

### **Rule 1. Drop Constants**

```java
    public static void printItems(int n) {
        for (int i = 0; i < n; i++){
            System.out.println(i);
        }
        for (int j = 0; j < n; j++){
            System.out.println(j);
        }
    }
```

Time Complexity for the above operation is not ~~_O(2n)_~~.  
We **DROP CONSTANTS** and say **O(n)**.

### **Rule 2. Drop Non-Dominants**

```java
    public static void printItems(int n) {
        for (int i = 0; i < n; i++){
           for (int j = 0; j < n; j++){
            System.out.println(i + " " + j);
            }
        }
        for (int k = 0; k < n; k++){
            System.out.println(k);
        }
    }
```

Time Complexity for the above operation is not ~~_O(n^2+n)_~~.  
We **DROP NON DOMINANTS** and say **O(n^2)**.

## **III. Common Functions**: 그래프 기울기 생각하면 간단함

### **1. O(n)**: linear

ex. Finding an item in an unsorted list or in an unsorted array

```java
    public static void printItems(int n) {
        for (int i = 0; i < n; i++){
            System.out.println(i);
        }
    }
```

### **2. O(n^2)**: quadratic

ex. Multiplying two-digit numbers by schoolbook multiplication; simple sorting algorithms, such as bubble sort, selection sort and insertion sort;

```java
    public static void printItems(int n) {
        for (int i = 0; i < n; i++){
           for (int j = 0; j < n; j++){
            System.out.println(i + " " + j);
            }
        }
    }
```

### **3. O(1)**: constant

**THE MOST EFFICIENT BIG O**

ex. Finding the median value for a **sorted array** of numbers; Using a **constant-size** lookup table

```java
    public static void printItems(int n) {
        return n + n;
    }
```

### **3. O(log n)**: logarithmic

**THE SECOND BEST EFFICIENT BIG O**

ex. Finding an item in a **sorted array** with a binary search or a balanced search tree as well as all operations in a binomial heap

```text
Find 1 from this 'sorted' array
[ 1, 2, 3, 4, 5, 6, 7, 8 ]

step1: [ 5, 6, 7, 8 ] > pass
step2: [ 3, 4 ] > pass
step3: [ 2 ] > pass

total of 3 steps needed to find the value
```

```text
How many steps needed to find a specific value out of 1,073,741,824 items

total of 30 steps needed to find the value
total of 31 steps in the worst-case scenario to confirm the value does not exist.
```

### **4. O(n log n)**: lineararithmic,loglinear,quasilinear

ex. Fastest possible comparison sort; **quicksort** and **merge sort**

## **IV. Multivariable Complexity (다중 변수 복잡도)**

popular gotcha interview question

**A. TIME COMPLEXITY FOR THIS PROCESS?**

```java
    public static void printItems(int a, b) {
        for (int i = 0; i < a; i++){
            System.out.println(i);
        }
        for (int j = 0; j < b; j++){
            System.out.println(j);
        }
    }
```

This is not ~~_O(n)_~~.  
This is **O(a + b)**.

**O(n) + O(n)으로 퉁칠 수 없는 이유**:  
Say, a is 1 and b is a billion. That makes two 'very different' for loops.  
Therefore, O(a) + O(b).  
This is as far as we can simplify this.

**B. TIME COMPLEXITY FOR THIS PROCESS?**

```java
    public static void printItems(int a, b) {
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                System.out.println(i + " " + j);
            }
        }
    }
```

This is not ~~_O(a+b)_~~.  
This is **O(a \* b)**.

## V. Big O of Array Lists

```java
List<Integer> myList = new ArrayList<>(Arrays.asList(11, 3, 23, 7));
```

[ 11, 3, 23, 7 ] 구성의 ArrayList

```java
myList.add(17); //[ 11, 3, 23, 7, 17 ]
myList.remove(4); // [ 11, 3, 23, 7 ]
```

`add`, `remove`: no re-indexing, 1 operation, **O(1)**

```java
myList.remove(0); // [ 3, 23, 7 ]
myList.add(0, 11); // [ 11, 3, 23, 7 ]
```

`remove`: re-indexing required, n-1 operations, **O(n-1) -> O(n)**  
`add`: re-indexing required, n+1 operations, **O(n+1) -> O(n)**

```java
myList.add(2, 99); // [ 11, 3, 99, 23, 7 ]
myList.remove(2); // [ 11, 3, 23, 7 ]
```

`add`: re-indexing required, n-2 operations, **O(n-2) -> O(n)**  
`remove`: re-indexing required, n-2 operations, **O(n-2) -> O(n)**

```
Search by value: O(n)
Search by index O(1)
```

| Operation Type  | Actual Steps  | Time Complexity |
| :-------------- | :------------ | :-------------- |
| Index 0         | n             | O(n)            |
| Index i         | n - i         | O(n)            |
| Last Index      | 0             | O(1)            |
| Search by Value | Linear scan   | O(n)            |
| Search by Index | Direct access | O(1)            |

## VI. Wrap up

| Complexity     | Rating       | Status             | Typical Examples                           |
| :------------- | :----------- | :----------------- | :----------------------------------------- |
| **O(1)**       | 👑 Excellent | Constant           | Accessing Array index, Hash Map lookup     |
| **O(log n)**   | 🟩 Good      | Divide and Conquer | Binary Search                              |
| **O(n)**       | 🟨 Fair      | Proportional       | Linear Search, Iterating a list once       |
| **O(n log n)** | 🟧 Bad       | Tolerable          | Merge Sort, Quick Sort, Heap Sort          |
| **O(n^2)**     | 🟥 Horrible  | Loop within a Loop | Nested loops, Bubble Sort                  |
| **O(2^n)**     | 💀 Failure   | Dead Zone          | Recursive Fibonacci, Brute-force passwords |
| **O(n!)**      | 💀 Failure   | Dead Zone          | Traveling Salesman (Brute-force)           |

### Personal Commentary

- 🟩 `O(1), O(log n), O(n)`: You need to **stay within this range** for standard logic. This is where high-performance code lives.

- 🟨 `O(n log n)`: Tolerable **only when performing specific tasks** like sorting or complex data organization.

- 🟥 `O(n^2)` : If you find yourself here, **you're likely doing something wrong**. It's a "scalability wall" that will crash your app in production.

- 💀 `O(2^n), O(n!)`: If you reach this zone, you are **deliberately trying your best to write "broken" code**. These algorithms don't just run slow—they fail to finish as $n$ increases.

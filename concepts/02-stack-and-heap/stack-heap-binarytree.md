### Concepts covered in this document

- **Big O** >> _refer to `01-time-complexity`_
- ✅ **Stack concept**
- ✅ **Heap/Binary Heap concept**
- ✅ **PriorityQueue(Java)**
- **Greedy scheduling logic**

---

### 1. Stack is 'stacking' Last in, First out. Heap is...?

Claude showed me a picture of a **tree**.

---

### 2. So heap is a tree, then?

Yes, internally.

---

### 3. So heap is a binary tree, then?

Almost, but not exactly.  
 A heap is a **specific type** of **binary tree**, but **not all** binary trees are heaps.

### Binary Tree

Any tree where each node has at most 2 children. No other rules.

### Binary Heap = Min Heap = PriorityQueue(Java)

A binary tree with two extra rules enforced

(1) **Shape**: MUST BE **FILLED** LEVEL BY LEVEL, LEFT TO RIGHT. NO GAPS.  
(2) **Order**: **MIN HEAP** - EVERY **PARENT** MUST BE **SMALLER** THAN ITS CHILDREN. (for **MAX HEAP**, the other way around)

> ❤️ TIP: Java's **PriorityQueue**'s default behavior is **min-heap**

---

### 4. So, 'binary heap' is just a specific version of 'binary tree'?

Exactly. **Every heap is a binary tree. Not every binary tree is a heap.**

---

### 5. Wait, what is the difference between 'heap' and 'binary heap'?

- **Heap** is the **concept**.
- **Binary heap** is the most common **implementation** using a binary tree.

They're used interchangeably.  
For 99% of interview, **heap = binary heap = PriorityQueue(Java)**

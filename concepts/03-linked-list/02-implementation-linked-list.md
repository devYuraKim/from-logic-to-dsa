## I. Blueprint

```java
public class LinkedList {

    public LinkedList(int value) {...}
    // create new Node

    public void append(int value) {...}
    // create new Node
    // add Node to end

    public void prepend(int value) {...}
    // create new Node
    // add Node to beginning

    public boolean insert(int index, int value) {...}
    // create new Node
    // insert Node

}
```

## II. `LinkedList(int value)`

all these **create new Node**

```java
class Node {

    int value;
    Node next;

    Node(int *value*){
        this.value = *value*;
    }
}
```

**create new LinkedList**

```java
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int *value*){
            this.value = *value*;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
}
```

### LinkedList traversal

print out LinkedList
(LinkedList 순회 로직 확인 목적)

```java
public void printList() {

    // Start traversal from the head (first node)
    Node temp = head;

    // Continue until we reach the end of the list (null)
    while (temp != null) {
        System.out.println(temp.value);
        // Move to the next node in the list
        temp = temp.next;
    }
}
```

## III. `append`

```java

```

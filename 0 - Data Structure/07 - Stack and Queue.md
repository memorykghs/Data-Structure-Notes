# 07 - Stack and Queue
## Stack
是一個類似陣列 ( array-like ) 的結構，並遵循 **LIFO** 規則：**L**ast **I**n， **F**irst **O**ut。

堆疊經常用桌上的一疊書做比喻，最後放上去的書，會最先被取出。
以下是 Stack 的標準操作與對應的時間複雜度：

* **Pushing an element onto the stack**: O(1)
* **Popping an element off the stack**: O(1)
* **Peeking at the element on the top of the stack**: O(1)
* **Searching for an element in the stack**: O(n)

Stack 通常會以  **Dynamic Array** 或 **Singly Linked List** 的形式實做。

## Queue
也是一個類似陣列 ( array-like ) 的結構，跟 Stack 相反，遵循 **FIFO** 的規則： **F**irst **I**n，**F**irst **O**ut。

Queue 則較常以一群人在排隊做為比喻，第一個排隊的人是第一個購買商品且離開排隊。
以下是 Queue 的標準操作與對應的時間複雜度：

* **Enqueuing an element into the queue**: O(1)
* **Dequeuing an element out of the queue**: O(1)
* **Peeking at the element at the front of the queue**: O(1)
* **Searching for an element in the queue**: O(n)

通常以 **Doubly Linked List** 實作。

## 實作
* https://openhome.cc/Gossip/Java/Queue.html
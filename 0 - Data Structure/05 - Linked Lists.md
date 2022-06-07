# 05 - Linked Lists

## Singly Linked List
由節點 ( node ) 組成，每個節點都包含一紀錄值的 value 以及記錄下一個節點的 pointer。也就是在 Linked List 中，值跟下一個節點的位置會分別記錄在 `value` 與 `next` 中，最後一個節點的 `next` 會指向 `null`。

![](/images/DataStructure/5-1.png)

下面是一個單向 Linked List 簡單的示意：
```
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
```

單向的 Linked List 通常會將第一個節點 ( head ) 暴露給使用者以方便訪問，但如果要找到特定的節點就必須遍歷所有指向該節點的其他關連節點 ( 和 Array 相反 )，新增或刪除節點的操作其實也只是更改 pointer 紀錄的值。

以下是單向 Linked List 的標準操作與對應的時間複雜度：
* get value：**O(i)** time、**O(n)** space time ( **i** 為指定元素長度 )
* set value：**O(i)** time、**O(n)** space time
* Accessing the head：**O(1)**
* Accessing the tail：**O(n)**
  因為必須遍歷所有節點才能知道最後一個節點的位置
  <br/>
  
* Accessing a middle node：**O(n)**
* Inserting / Removing the head：**O(1)**
* Inserting / Removing the tail：**O(n) to access + O(1)**
  必須先透過遍歷找到最後一個節點，然後改變上一個節點 pointer 紀錄的值
  <br/>

* Inserting / Removing a middle node：**O(n) to access + O(1)**
* Searching for a value：**O(n)**

## Doubly Linked List
與單向的 Linked List 相似，不同的地方是每個節點中分別有紀錄前一個節點雨後一個節點位置的 pointer，通常以 `prev` 與 `next` 表示。最後一個節點的 `next` 與第一個節點的 `prev` 都指向 `null`。

```
null <- 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 -> null
```

另外不同的還有，雙向 Linked List 會將第一個節點與最後一個節點的位置暴露給使用者操作，其他的行為都與單向 Linked List 相似。以下為雙向 Linked List 的標準操作與對應的時間複雜度：

* Accessing the head：**O(1)**
* Accessing the tail：**O(1)**
* Accessing a middle node：**O(n)**
* Inserting / Removing the head：**O(1)**
* Inserting / Removing the tail：**O(1)**
* Inserting / Removing a middle node：**O(n) to access + O(1)**
* Searching for a value：**O(n)**

## Circular Linked List
沒有明確的起始與結束節點，因為此結構的 `tail` 會指向 `head` 形成一個封閉的圓圈。而循環 Linked List 可以是單向或雙向。
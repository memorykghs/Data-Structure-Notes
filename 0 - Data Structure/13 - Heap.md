# Heap
## What is Heap?
> A Heap is a special Tree-based data structure in which the tree is a complete binary tree.

Heap 是一個特殊的、基於 Tree 結構的完滿樹 ( Complete Binary Tree )。

* 只要有左節點，那麼一定有右節點 ( 或是都沒有子節點 )
* 因為不是完美二元樹 ( Perfect Binary Tree )，所以左右葉節點不需要有相同的深度

    ```          
              1
           /     \
          2       3
        /   \   /   \
       4     5 6     7
     /   \
    8     9
    ```
## Binary Heap & Min Heap & Max Heap
參考：[資料結構大便當](https://medium.com/@Kadai/%E8%B3%87%E6%96%99%E7%B5%90%E6%A7%8B%E5%A4%A7%E4%BE%BF%E7%95%B6-binary-heap-ec47ca7aebac)

[圖片來源](https://en.wikipedia.org/wiki/Heap_(data_structure)#/media/File:Max-Heap.svg)

#### Binary Heap
* 每個節點最多有兩個 `child`
* 同一階層要由左到右排列，不能跳過。
  ex. 像下面這張圖的 child node `2` 跟 `7`，不能直接接在 node `3` 下造成 node `17` 沒有子節點。
![](/images/DataStructure/13-1.png)

---

Heap 在實作上可以用一個 List 來表示，由上到下、由左至右的排列在 List 中：
![](/images/DataStructure/13-2.png)

另外有一個特性可以幫助我們在 List 中快速地找到 left child node 或是 right child node。

如果目前的 node 的 number 是 `n`：
* left child node 的 number 就是 `2*n`
* right child node 的 number 就是 `2*n + 1`

但因為寫程式的時候，index 是從 0 開始的，所以我們可以簡單做個轉換。如果目前的 node 的 index 是 `i`：

* left child node 的 index 就是 `2*i + 1`
* right child node 的 index 就是 `2*i + 2`


#### Max Heap & Min Heap
* **Max Heap**：每個父節點的值絕對會比兩個子節點還要大。代表 `root` 的值在這個結構中一定是最大的。

* **Min Heap**：每個父節點的值絕對會比兩個子節點還要小。代表 `root` 的值在這個結構中一定是最小的。

![](/images/DataStructure/13-3.png)

[圖片來源](https://www.geeksforgeeks.org/heap-data-structure/)

## Operation of Heap Data Structure
* Insertion：在現有 Heap 中插入一個元素的過程，時間複雜度為 `O(log N)`。
* Deletion：刪除根結點或優先級最高的元素，然後重組 Heap，時間複雜度為 `O(log N)`。
* Heapify：從陣列創建 Heap 的過程。可以依照方向再分成 HeapifyUp 以及 HeapifyDown。
* Peek：檢查或查找堆中最優先的元素 ( 根節點 )。

#### HeapifyDown
![](/images/DataStructure/13-4.png)

#### HeapifyUp
![](/images/DataStructure/13-5.png)

[圖片來源](https://www.techiedelight.com/zh-tw/introduction-priority-queues-using-binary-heaps/)

## 實作
↓ 爆幹好笑www
[Rap Battle: Developer vs. Product Manager](https://www.youtube.com/watch?v=cTJeUTzSOHo)

但另外一部同一個 Youtuber 上傳的影片很棒 😂
[Data Structures: Heaps](https://www.youtube.com/watch?v=t0Cq6tVNRBA)

## 參考
* https://www.geeksforgeeks.org/heap-data-structure/
* https://ryanchen34057.github.io/2019/09/01/heapify/
* https://medium.com/@Kadai/%E8%B3%87%E6%96%99%E7%B5%90%E6%A7%8B%E5%A4%A7%E4%BE%BF%E7%95%B6-binary-heap-ec47ca7aebac
* https://www.techiedelight.com/zh-tw/introduction-priority-queues-using-binary-heaps/
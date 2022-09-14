# 04 - Array
## Array
  A linear collection of data values that are accessible at numbered indices, starting at index 0.

以下是 Array 的標準操作及其對應的時間複雜度：
  * 初始：**O(n)**
  * 對特定 index 設值：**O(1)**
  * 更新特定 index 的值：**O(1)**
    * 因為要取得某個索引的值只要算好是哪一格的資料即可
    假設：此為 int 陣列，每個數值長度是 8 bytes，也就是 64 bits，要取得索引為 1 的值，從第 11 個記憶體位址開始，等於是走了 $2*8$ 個記憶體，而計算 Big O 時只關注在非常數的部分，所以每次取得某個位址的值相當於是 O(1)。
    ![](/images/DataStructure/4-1.png)
<br/>

  * 插入值
    * 在陣列最前面插入值：**O(n)** &rArr; 因為所有值都要往後移
    * 在陣列中間插入值：**O(n)** &rArr; 可能只需要移 $n/2$，但常數不是關注重點，所以還是 O(n)
    * 在陣列尾端插入值：
      * Dnamic Array：平均攤銷下來為 **O(1)** &rArr; 可以隨便找一個記憶體位置塞入
      * Static Array：**O(n)** &rArr; 有可能超出原本的的長度，若沒有連續的記憶體位置，則需要將陣列複製到新位置
<br/>  

  * traverse 遍歷：**O(n)** time、**O(1)** space time &rArr; n 個元素就做 n 次，每次取得值得 Big O 是 **O(1)**
<br/>
  
  * 從陣列前端移除某個值：**O(n)** &rArr; 需要將後面的值往前移動
  * 從陣列中間移除某個值：**O(n)**
  * 從陣列尾端移除某個值：**O(1)** &rArr; 因為陣列一開始是有預設長度的，在這個前提下，我們可以知道最尾端連續記憶體位置是哪一個
  * 複製陣列：**O(n)**

靜態 array 會先分配固定的記憶體位址來儲存值，所以當儲存的值超出原本的記憶體上限，就無法再繼續儲存，而這個過程是一個線性的時間操作 ( linear-time operation )。

而動態的 array 是預先分配兩倍的內存記憶體來儲存值，對 array 插入值是一個恆定時間的操作 ( constant-time operation )，直到分配的記憶體位址被填滿。當沒有空的記憶體位置時，就會先複製現有的陣列到新的記憶體位置，並且將長度擴展為現有的兩倍，再將新的值寫入，此操作的平均成本如下：

![](/images/DataStructure/4-3.png)

## ArrayList vs. Queue
> A **Collection** is a container for grouping objects together.
> A **List** is an _ordered_ Collection of objects.
> A **Queue** is a Collection of objects _accessed_ in the order they're insterted.
> An **ArrayList** is a List of object whose elements can be accessed _randomly_.

* https://www.quora.com/What-the-difference-between-a-queue-list-collection-and-ArrayList-in-Java


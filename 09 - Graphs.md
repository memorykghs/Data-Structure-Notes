# 09 - Graphs
一個由一些相關的**點 ( vertices )** 或**值**組成的集合，點與點之間可以用**邊 ( edges )** 相連，代表他們的關係。生活中有許多例子可以用 Graph 來表示，例如設銷網路：每個點代表使用者，他們之間的友誼則用邊來連接。

![](/images/9-1.png)

p.s. 不建議記住 Graph 的所有類型與行為，建議看到圖的時候觀察他們之間的特性再作分析即可。

像上面那張圖可以發現幾個現象：
1. `Node 3` 跟 `Node 6` 是沒有辦法連接到 Graph 的其他 Node，代表 not connected graph。
2. 部分的點之間是有方向性的，可以分成**單向 ( one-way direction )** 與 **雙向 ( two-way direction )**。

## Graph Cycle
當一個途中出現了點與點之間相連，形成一個閉環的情況，稱為 **Graph Cycle**。

需要注意閉環形成的條件，點與點之間關連的長度並非都是 1，有可能出現長度為 2 或不定，但仍是一個 Graph Cycle 的情況。所以對於涉及 Graph 循環的問題，要先弄清楚什麼剛好在一個循環中。

## Acyclic
**Graph** 中沒有 **cycles**。

## Cyclic Graph
**Graph** 終止至少有一個 **cycle**。

## Directed Graph
**Graph** 的 **edges** 是有方向性的 ( directed )，代表他們只能從某一個指定的方向被遍歷 ( traverse )。

例如，機場和航班圖很可能是有向的，因為
航班專門從一個機場飛往另一個機場 ( 它有一個
方向 )，但不一定有返回的班機。

## Undirected Graph
**Graph** 的 **edges** 是無向的，代表它們可以從兩個方向被遍歷。例如網絡關係中的朋友關係，因為友誼本質上是雙向的。

## Connected Graph
如果對於圖中的每一對 ** 頂點 **，則 ** 圖 ** 是連通的
有一條或多條 ** 邊 ** 連接給定頂點的路徑。

**Graph** 中每一對 **點 ( vertice )** 都有一條或多條**邊 ( edges )** 連結，稱為 Connected Graph。

在 **有向圖 ( Directed Graph )** 的情況下：

* **Strongly Connected**：
每對點與點之間如果存在雙向連接，對於每個頂點對 `(u, v)`，可以從 `u` 到達 `v`，也可以從 `v` 到達 `u`。

* **weakly connected**：
每對點與點之間有連接，但不一定是雙向連接。

* 其他沒有被連接的 Graph 稱為 **disconnected**。

## 參考
* https://ithelp.ithome.com.tw/articles/10208277
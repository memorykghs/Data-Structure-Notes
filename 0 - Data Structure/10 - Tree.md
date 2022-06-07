# 10 - Tree
Linked List 是一維的線性結構 ( 不是往前、就是往後 )，樹 ( 與 Graph ) 則推廣成多維的結構。

由**Node ( 節點 )** 組成的資料結構，每個節點都包含特定的值 ( value ) 和指向子節點 ( child-nodes ) 的 pointer，如此遞迴形成一個一個的 **subtree** 組成的樹狀結構。

![](/images/DataStructure/10-1.png)

## Tree 中的角色
* **root 根節點**
Tree 中的第一個節點。
<br/>

* **leaf nodes 葉節點** 或 **leaves 葉**
最底部的節點 ( 指沒有子節點的點 )，就像樹葉不可能再分岔出樹幹一樣的概念。
<br/>

* **branches 分支、樹枝**
根節點與其他子節點之間的路徑。

## 描述 Tree 的元素

![](/images/DataStructure/10-3.png)

* **degree 分歧度**
一個 node 擁有的 subtree ( 子樹 ) 的個數。如上圖，root 的 degree 是 2，它擁有 `node 2` 與 `node -7` 兩個後代。
<br/>

* **level**
定義 root 的 level 為 1，其餘 node 的 level 為其parent 的 level 加一。
<br/>

* **height 高度**
一個節點與其後代中最長的分支的長度，leaf node 的height 為 0。一棵樹的 height 就是 root 的 height。
<br/>

* **depth 深度**
root 與 leaf node 之間的 path 的距離。
<br/>

Tree 實際上是一個有效率的、**connected**、**directed ( 有方向的 )** 且 **acyclic ( 不循環的 )** 的 Graph。它有一個明確的根節點，除了根節點之外，每個節點都有且只有一個父節點 ( parent node )。

與 Graph 不同的地方是：
* 每個節點連接的只有父節點，且不可以形成 cycle。
* 一個 Tree 只會有一個根節點，如果出現了兩個斷掉部相連的結構，會視為兩個 Tree。
* 在 Tree 中若要從 root 尋找特定 node，一定只存在一條路徑 ( path )。

樹狀結構的類型有很多種：
* **Binary Trees** 二元樹
常聽到的有 Binary Tree Search ( BTS ) 二元樹搜尋法，擁有某些特徵的樹狀結構。
<br/>

* **Heaps**
  * Min Heaps
  * Max Heaps
<br/>

* **Tries**
是一個 tree-like 的結構，可以依照類似樹狀結構的方式儲存一些值。

## Tree 的標準操作與複雜度
* Traverse Balanc Tree：**O(log(N))**
  在結構不歪斜的情況下，因為每次都只能選擇一個 subtree ( 從剩下的結果中選擇一半去遍歷 )，要循環所有的 subtree 直到找到結果。<br/>

  ![](/images/DataStructure/10-2.png)

## Different Type of Tree
#### Binary Tree 二元樹
一種每個節點都只有 2 個子節點的樹狀結構。二元樹的結構使得其操作具有對數時間複雜度。

#### K-ary Tree

  A **tree** whose nodes have up to **k** child-nodes. A
  **binary tree** is a k-ary tree where **k == 2**.

#### Perfect Binary Tree

  A **binary tree** whose interior nodes all have two child-nodes and whose
  **leaf nodes** all have the same **depth**. Example:
 
```           
           1
      /         \
     2           3
   /   \       /   \
  4     5     6     7
 / \   / \   / \   / \
8   9 10 11 12 13 14 15
```

#### Complete Binary Tree
一個幾乎**完美 ( perfect )** 的二元樹，他的每一個節點都有 2 個子節點，但葉節點可以不需要有相同的深度。另外子節點的位置要由左至右被填滿，如果中間有空缺就不算 Complete Binary Tree。

> 範例一 
```          
          1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
 /   \
8     9
```
上圖是一個 Complete Binary Tree。

> 範例二

下圖就是一個相反的例子，它是一個不完整的 Binary Tree，因為最後一層的節點，並沒有由左到右被填滿，`node 4` 沒有子節點，但 `node 5` 跟 `node 6` 有一個子節點。

```
          1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
        /   \
       8     9
```

#### Balanced Binary Tree 平衡二元樹
每一個節點都有左跟右的 subtree，且每個 subtree 的高度相差不超過 1，也因為這樣的結構， 平衡二元樹的時間操作複雜度會維持在 O(log(N))。

> 範例一 
```             
             1
          /     \
         2       3
       /
      4
    /
   8
  /
10
```
上圖顯然不是一個平衡二元樹，因為左邊明顯是一個不對稱的結構，會花大量的時間在遍歷左邊的 subtree。

> 範例二

下圖就是一個比較常看到的平衡二元樹。
```         
          1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
 /   \         /   
10    9       8
```

#### Full Binary Tree
樹狀結構中的所有子節點都包含 0 或 2 個子節點，稱作 Full Binary Tree。

> 範例一

下圖是一個 Full Binary Tree。
```    
    1
 /     \
2       3
      /   \
     6     7
   /   \
  8     9
```
下面這個也是一個 Full Binary Tree，但它不是 complete 的。
```         
          1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
 /   \         /   \
10    9       8     11
```

> 範例二
```    
    1
 /     \
2       3
      /   \
     6     7
   /
  8     
```
這就不是一個 Full Binary Tree，因為 `node 6` 只有一個子節點。

## 參考
* AlgoExpert
* http://alrightchiu.github.io/SecondRound/treeshu-introjian-jie.html
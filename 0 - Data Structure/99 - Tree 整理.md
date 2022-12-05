# 10.99 - Tree 整理
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

## 實作
大致上可以分為兩種：
* Node
  * 不會特別限制有多少個 children node
  * 會有 List<Node> 結構，用來記錄其子節點
* TreeNode
  * 通常會用在二元樹的結構
  * 只會有左右兩個子節點，由 `left` 和 `right` 兩個屬性紀錄

## Breath-first Search
* [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=study-plan&id=level-1)

## Depth-first Search

* [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan&id=level-1)
* [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=study-plan&id=level-1)
* [589. N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/?envType=study-plan&id=level-1)
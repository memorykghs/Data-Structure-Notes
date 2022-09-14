# 103 - Binary Tree Zigzag Level Order Traversal

* [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

## Related Topics
* Tree
* Breadth-First Search
* Binary Tree

## My Solution
一開始覺得會是 Stack 的結構，不過後來發現其實應該是 Queue，用 Stack 的結構會打亂當前遍歷這層的 Node 以及下一層 Sub Node 的順序。

## Well Solution
* 邏輯解說影片：https://drive.google.com/file/d/1PEiK85XGnx8APIIFAflR_gmC8TqN-RBy/view?usp=sharing

```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) {
        return result;
    }

    boolean isLeftToRight = true; // 判斷由右邊還是左邊開始，第一層由左邊開始
    Queue<TreeNode> queue = new ArrayDeque<>(); // 紀錄每一層的節點
    queue.add(root);

    while (!queue.isEmpty()) {

        int size = queue.size();
        List<Integer> tempList = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            TreeNode current = queue.poll();

            // 如果是由左到右，就順著放(新元素加在尾端)
            if (isLeftToRight) {
                tempList.add(current.val);
                
            } else { // 由右到左，新元素放第一個
                tempList.add(0, current.val);
            }

            if (current.left != null) { // 放入下一輪的，都由左到右
                queue.add(current.left);
            }

            if (current.right != null) { // 放入下一輪的，都由左到右
                queue.add(current.right);
            }

        }

        isLeftToRight = !isLeftToRight;
        result.add(tempList);
    }

    return result;
}
```

## 參考

#### 影片
* https://www.youtube.com/watch?v=3OXWEdlIGl4
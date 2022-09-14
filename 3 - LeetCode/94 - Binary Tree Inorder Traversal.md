# 94 - Binary Tree Inorder Traversal

* [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

## Related Topics
* Stack
* Tree
* Depth-First Search
* Binary Tree

## My Solution
知道邏輯但是有點寫不出來...ˊ ˋ

## Well Solution
真的是依照某個模板下去寫的，像是下面這樣：
```java
if(root == null) {
    ...
			
} else { // root 不為 null，往下遍歷
    
    inorder(root.left, result); // traversal left
    result.add(root.val); // add root
    inorder(root, result); // traversal right
}
```
其中 `inorder()` 的部分就像本題的 `while loop` 裡面做的事情，做完再往 `root` 以及 `right` 移動。不過因為本題其實會先把 `left` 的節點先遍歷完，所以要把根節點記起來才有辦法往右邊遍歷。

下面將經過的根節點紀錄在 Stack 中。

![](/images/DataStructure/94-1.png)
[圖片來源](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/discuss/31213/Iterative-solution-in-Java-simple-and-readable)

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    
    while (current != null || !stack.empty()) {
        while(current != null) {
            stack.add(current);
            current = current.left;
        }
        
        
        current = stack.pop();
        result.add(current.val);
        current = current.right;
    }
    
    return result;
}
```

![](/images/Algorithm/binary%20tree/binary%20tree%20-%201.gif)

有人會再把中間兩個 `while` 的部分切一個 `private method()` 出來。

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/discuss/31213/Iterative-solution-in-Java-simple-and-readable

#### 影片
* https://www.youtube.com/watch?v=g_S5WuasWUE
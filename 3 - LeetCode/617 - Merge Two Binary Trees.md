# 617 - Merge Two Binary Trees

* [Merge Two Binary Tree](https://leetcode.com/problems/merge-two-binary-trees/)

## Related Topics
* Tree
* Depth-First Search
* Breadth-First Search
* Binary Tree

## My Solution
嗯...沒有思考太久，但感覺號的記憶體可以再少一點。

```java
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    // corner case
    if(root1 == null) {
        return root2;
    }
    
    if(root2 == null) {
        return root1;
    }
    
    TreeNode newNode = new TreeNode(root1.val + root2.val);
    
    newNode.left = mergeTrees(root1.left, root2.left);
    newNode.right = mergeTrees(root1.right, root2.right);
    
    return newNode;
}
```

![](/images/LeetCode/617-1.png)

## Well Solution
下次有機會再看XD


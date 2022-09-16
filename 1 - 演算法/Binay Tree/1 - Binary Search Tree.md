# 1 -  Binary Search Tree

## 解題模板
### Binary Tree / Symmetric Tree
通常都是把 node 傳入遞迴 method 進行判斷。
```java
public boolean isSymmetric(TreeNode root) {
    return validateNode(root.left, root.right);
}

private static boolean validateNode(TreeNode left, TreeNode right) {
    if(left == null || right == null) {
        return left == right;
    }
    
    if(left.val != right.val) {
        return false;
    }
    
    return validateNode(left.left, right.right) && validateNode(left.right, right.left);
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
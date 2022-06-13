# 101 - Symmetric Tree

* [Symmetric Tree](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627)

## Related Topics
* Binary Tree
* Symmetric Tree

## My Solution
有點冗。
```java
public boolean isSymmetric(TreeNode root) {
    return validateNode(root.left, root.right);
}
	
private static boolean validateNode(TreeNode left, TreeNode right) {
    if((left != null && right == null) || (left == null && right != null)) {
        return false;
    }
    
    if() {
        ...
    }
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

## Well Solution
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
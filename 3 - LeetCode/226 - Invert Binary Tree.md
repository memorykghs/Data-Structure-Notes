# 226 - Invert Binary Tree

* [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

## Related Topics
* Tree
* Depth-First Search
* Breadth-First Search
* Binary Tree

## My Solution
直接給一個 new root 串樹狀結構。

```java
public TreeNode invertTree(TreeNode root) {
    if(root == null) {
        return null;
    }
    TreeNode temp = new TreeNode(root.val);
    
    temp.left = invertTree(root.right);
    temp.right = invertTree(root.left);
    
    return temp;
}
```

## Well Solution
直接將其中一半的 sub tree cache 起來，就不用給定一個新的 root。

```java
public TreeNode invertTree(TreeNode root) {
    if(root == null) {
        return null;
    }

    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);
    
    return root;
}
```

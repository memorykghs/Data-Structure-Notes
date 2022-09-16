# 105 - Construct Binary Tree from Preorder and Inorder Traversal

* [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## Related Topics
* Array 
* Hash Table
* Divide and Conquer
* Tree
* Binay Tree

## My Solution
有推出結構但是演算法寫不出來QQQ

## Well Solution
```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(0, 0, inorder.length - 1, preorder, inorder);
}

private static TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    
    TreeNode root = new TreeNode(preorder[preStart]);
    
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    
    root.left = build(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}
```

## 參考

#### 影片
* ttps://www.youtube.com/watch?v=ihj4IQGZ2zc
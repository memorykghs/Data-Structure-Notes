# Binary Tree

* full binary tree：除了樹葉以外，每個節點都有兩個小孩。
* complete binary tree：各層節點全滿，除了最後一層。
* perfect binary tree：各層節點全滿。同時也是 full binary tree 和 complete binary tree。

![](/images/Template/binary_tree-1.png)

## 資料結構
每個節點會用指標儲存其子節點。
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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

![](/images/Template/binary_tree-2.png)

也可以使用陣列儲存，但在儲存歪斜樹上，用 node 的方式儲存較為節省空間。陣列的儲存方式如下：
```
[1, null, 2, null, null, 3]
 ↑        ↑              ↑
 root  2nd right node   3rd right node
```

不過對於樹葉或終端節點而言，還是會有一些指標儲存的浪費，因為樹葉並不包含子節點。

## Binary Search Tree

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


## 參考
* https://web.ntnu.edu.tw/~algo/BinaryTree.html
* https://ithelp.ithome.com.tw/articles/10242571
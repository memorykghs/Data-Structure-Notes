# 104 - Maximum Depth of Binary Tree

* [Maximum Depth of Binary Tree](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555)

## Related Topics
* Tree
* Binary Tree

## My Solution
沒想法...

## Well Solution
#### 解題思維
1. 因為是 Binary Tree，所以只要找出 left branch 及 right branch 哪一邊比較長即可。
2. 使用遞迴去搜尋深度，直到最後的 node。
3. 判斷當前的節點是否有子節點，有節點且 left branch 或 right branch 有值，則 depth + 1。

![](/images/LeetCode/104-1.png)

```java
public int maxDepth(TreeNode root) {

    // 判斷 root node 是否存在，不存在則 depth = 0
    if (root == null) {
        return 0;
    }

    // 如果有分支的話，判斷分支深度
    // 有 node 則 depth + 1
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return Math.max(left, right) + 1;
}

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

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/discuss/1769344/Java-C++-Easy-to-go-Explanation-and-Solution
* https://www.youtube.com/watch?v=1XC3p2zBK34
* https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/104md.html
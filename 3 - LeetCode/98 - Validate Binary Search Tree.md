# 98 - Validate Binary Search Tree

* [Validate Binary Search Tree](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625)

## Related Topics
* Binary Tree
* Recursive

## My Solution
但忘記左邊的肯定要比右邊的小...所以以下這種情況會是 `false`。

![](/images/LeetCode/98-1.png)

```java
public static boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (root.left != null && root.left.val >= root.val) {
			return false;
		}

		if (root.right != null && root.right.val <= root.val) {
			return false;
		}

		isValidBST(root.right); // 檢核右邊節點
		isValidBST(root.left); // 檢核左邊節點

		return true;
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
![](/images/LeetCode/98-2.png)

1. left branch 的檢核條件為 `-∞ < node < 5`
2. right branch 的檢核條件為 `5 < x < ∞`

```java
public static boolean isValidBST(TreeNode root) {
		return validNode(root, null, null);
	}
	
private static boolean validNode(TreeNode node, Integer minVal, Integer maxVal) {

	if (node == null) {
		return true;
	}

	if ((maxVal != null && node.val >= maxVal) || (minVal != null && node.val <= minVal)) {
		return false;
	}

	return validNode(node.left, minVal, node.val) && validNode(node.right, node.val, maxVal); // 檢核左邊和右邊的節點
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
* https://www.youtube.com/watch?v=s6ATEkipzow
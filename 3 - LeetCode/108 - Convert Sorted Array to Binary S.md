# 108 - Convert Sorted Array to Binary Search Tree

* [Convert Sorted Array to Binary Search Tree](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631)

## Related Topics
* Binary Tree


## Well Solution
1. 找出中位數依次往下區分 left branch 及 right branch
2. 中位數 = ( `low` index + `high` index ) / 2
3. `high` index = `nums.length - 1`
4. 也就是說 left branch 的 index 介於 `low` ~ `median - 1`，right branch 則介於 `median + 1` 與 `high` 之間

![](/images/LeetCode/108-1.png)

```java
public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
        return null;
    }

    return handleNode(nums, 0, nums.length - 1); // 丟入排序好的陣列的最小、最大值
}

private TreeNode handleNode(int[] nums, int low, int high) {
    
    if(low > high) {
        return null;
    }

    int medianIndex = (low + high) / 2;
    
    TreeNode root = new TreeNode(nums[medianIndex]);
    root.left = handleNode(nums, low, medianIndex - 1); // 找左半邊的 index
    root.right = handleNode(nums, medianIndex + 1, high); // 找右半邊的 index
    
    return root;
}
```

## 參考
* https://www.youtube.com/watch?v=5G7jNmqGUck
# 704 - Binary Search

* [Binary Search](https://leetcode.com/problems/binary-search/)

## Related Topics
* Array
* Binary Search

## My Solution
利用遞迴的方式找到目標值：
1. 先找出中位數
2. 判斷目標值介於右邊子樹還是左邊子樹
3. 不斷判斷直到找到目標值為止

```java
private int midIndex;

public static int search(int[] nums, int target) {
    searchNum(0, nums.length - 1, nums, target);
    return midIndex;
}

private void searchNum(int begin, int end, int[] nums, int target) {

    midIndex = begin + (end - begin) / 2;
    int middle = nums[midIndex];

    if (target < middle) { // right sub tree
        searchNum(0, midIndex, nums, target);

    } else if (target > middle) { // left sub tree
        searchNum(midIndex, end, nums, target);
    }
}
```

但是報了 `java.lang.StackOverflowError`，有可能是呼叫太多層結果超出了 Stack 的容量。
![](/images/LeetCode/704-1.png)

## Well Solution
相同是依照目標值來決定區間，但是直接增減 `begin` 或 `end` 的值就好，不需要一直跑遞迴，用 `while` loop 就解決了。
```java
public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int begin = 0;
    int end = nums.length - 1;
    while (begin <= end) {
        int mid = begin + (end - begin) / 2;

        if (target < nums[mid]) {
            end = mid - 1;

        } else if (target > nums[mid]) {
            begin = mid + 1;

        } else {
            return mid;
        }
    }
    return -1;
}
```

## 參考
* https://leetcode.com/problems/binary-search/discuss/151320/concise-Java-solution-beats-100
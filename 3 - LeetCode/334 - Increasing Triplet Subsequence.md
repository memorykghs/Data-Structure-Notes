# 334 - Increasing Triplet Subsequence

* [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)

## Related Topics
* Array
* Greedy

## My Solution
原本想用 Queue，但這樣還要在寫一個迴圈判斷裡面的內容是不是符合題意。整體成本會是 O(n<sup>2</sup>)。

## Well Solution
直接用兩個變數 keep 前面的值，結束。

```java
public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    // fix window, so uses Queue
    // Queue<Integer> queue = new LinkedList<>();

    for (int num : nums) {

        if (num <= first) {
            first = num;
        } else if (num < second) {
            second = num;
        } else if (num > second) {
            return true;
        }

    }

    return false;
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/discuss/79000/My-accepted-JAVA-solution-for-this-question-only-7-lines-clear-and-concise.
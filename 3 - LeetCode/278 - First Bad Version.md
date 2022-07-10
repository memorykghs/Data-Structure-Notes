# 278 - First Bad Version
* [First Bad Version](https://leetcode.com/problems/first-bad-version/)

## Related Topics
* Binary Search
* Interactive

## My Solution
一開始看不懂題目要幹嘛...

> You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

> Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

> You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

大概就是你是一個產品經理，但很不幸的你的團隊最新發布的版本有品質上的缺失，在這個版本之後的產品會**全部失敗**。

假設現在有 `n` 個版本 `[1, 2, ..., n]`，而你想要找出最一開始壞的那個 ( 因為這個版本後都是壞掉的 )。

在這個問題當中會提供一個用來確認現在的版本是否是壞掉的的 API `boolean isBadVersion(version)` 來幫助你判斷，你需要做的就是 call 越少次 API 越好。

## Well Solution
```java
public int firstBadVersion(int n) {
    // 題目意在找出第一個壞掉的產品，用二元樹搜尋法會比一個一個跑迴圈快
    int start = 1;
    int end = n;

    while (start < end) {
        // 因為只要一個壞掉，後面的就跟著壞
        // 所以先找出中位數
        int mid = start + (end - start) / 2;
        if(!isBadVersion(mid)) {
            start = mid + 1;
        }else {
            end = mid;
        }
    }
    return start;
}
```

## 參考
* https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/278md.html

* https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/discuss/71296/O(lgN)-simple-Java-solution
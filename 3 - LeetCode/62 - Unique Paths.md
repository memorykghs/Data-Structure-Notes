# 62 - Unique Paths

* [Unique Paths](https://leetcode.com/problems/unique-paths/)

## Related Topics
* Dynamic Programming
* Combinatorics
* Math

## My Solution
看完刷提實戰筆記的一些歸納方法與總結，好像有了解一點點動態規劃要怎麼下手 = =+。

因為是尋求最大不同路徑，此題的變化有兩個方向：
1. 往右
2. 往左

所以每往下或是右邊一格，就會有一排的 row 或是 column 不能用。也就是說下一個動作變化路徑數量是前一個步驟的加總。

![](/images/LeetCode/62-1.png)

```java
private int[][] dp;

public int uniquePaths(int m, int n) {

    dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            uniquePathsHelper(i, j, m, n);
        }
    }

    return dp[m - 1][n - 1];
}

private void uniquePathsHelper(int i, int j, int m, int n) {

    if (i == m || j == n) {
        return;
    }
    if (i == 0 || j == 0) {
        dp[i][j] = 1;

    } else {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
}
```

## Well Solution
```java

```

## 參考
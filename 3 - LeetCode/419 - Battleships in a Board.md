# 419 - Battleships in a Board

* [Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/)

## Related Topics
* Array
* Depth-First Search
* Matrix

## My Solution
跟趨勢的比起來好寫很多，一開始就是二維陣列了。再看看有沒有更好的解法。

```java
public int countBattleships(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    int total = 0;

    for (int i = 0; i < m; i++) { // 由左往右一排一排順序輪
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'X') {
                getSizeShip(m, n, i, j, board);
                total++;
            }
        }
    }

    return total;
}

private void getSizeShip(int m, int n, int i, int j, char[][] board) {

    board[i][j] = '.';

    // top
    if (i > 0 && board[i - 1][j] == 'X') {
        getSizeShip(m, n, i, j, board);
    }

    // right
    if (j < n - 1 && board[i][j + 1] == 'X') {
        getSizeShip(m, n, i, ++j, board);
    }

    // bottom
    if (i < m - 1 && board[i + 1][j] == 'X') {
        getSizeShip(m, n, ++i, j, board);
    }

    // left
    if (j > 0 && board[i][j - 1] == 'X') {
        getSizeShip(m, n, i, j, board);
    }
}
```

## Well Solution
```java

```

## 參考
#### 影片
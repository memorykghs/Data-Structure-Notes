# 36 - Valid Sudoku

* [Valid Sudoku](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/)

## Related Topics
* Array

## My Solution
完全想不出來呢(´･ω･`)?

## Well Solution
#### 解題思維
1. 需要判斷：
    (1) 每個 row 是否有重複
    (2) 每個 column 是否有重複
    (3) 每個 boxes ( 小的九宮格 ) 是否有重複
<br/>

2. 將內部九個小的九宮格簡化
![](/images/LeetCode/LeetCode/36-1.png)

3. 取得每一個字元，用拼接的方式將值跟位置記錄在 HashSet 中，並以此判斷每個 row、column、box 中是否有重複
    * `'4'` in row `7` is encoded as `"(4)7"`.
    * `'4'` in column `7` is encoded as `"7(4)"`.
    * `'4'` in the top-right block is encoded as `"0(4)2"`.
<br/>

4. 判斷小的九宮格使用 `[i,j]` &rarr; `i/3 + - + j/3`，這樣就可以知道現在到底在哪個 box ( 如下圖藍字的 index )
![](/images/LeetCode/LeetCode/36-2.png)

5. 讀一個數獨board使用雙層的for loop，每次讀一個row

```java
public static boolean isValidSudoku(char[][] board) {

    Set<String> seen = new HashSet<>(); // 已經出現過的數字

    for (int i = 0; i < 9; i++) { // 9x9 的 index 所以跑兩個迴圈
        for (int j = 0; j < 9; j++) {

            char chr = board[i][j];
            if (chr != '.') {
                if (!seen.add(chr + " in row " + i) || // 判斷 row
                    !seen.add(chr + " in column " + j) || // 判斷 column
                    !seen.add(chr + " in block " + i / 3 + "-" + j / 3)) { // 判斷 boxes

                    return false;
                }
            }
        }
    }
    
    return true;
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/discuss/15472/Short+Simple-Java-using-Strings
* https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/36md.html
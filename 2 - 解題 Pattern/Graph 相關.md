# Graph 相關

## 題型
#### 遍歷
1. Pre-order traversal
2. In-order traversal
3. Post-order traversal

#### 二維陣列 / 島嶼問題
ex. 算出相島嶼有幾座
[200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```

通常解題的模式如下：
1. 遍歷二維陣列
2. 遍歷的過程以 DFS 為主，所以會由 method `isIsland()` 處理條件是否被滿足
3. `isIsland()` 方法中，先針對 corner case / 停止條件做檢核。以此範例而言，除了邊界，另外一個停止條件就是當值為 `0` 的時候不需要繼續往下。
4. 但如果通過檢核條件，那麼上下左右方向的格子都要檢查
```java
public int numIslands(char[][] grid) {

    int islands = 0;
    
    for(int i = 0; i < grid.length; i++) { // row
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == '1') { // 該格子為 1 再進去判斷
                isIsland(grid, i, j);
                islands++;
            }
        }
    }
    
    return islands;
}

private void isIsland(char[][] grid, int row, int column) {
    
    if(row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
        return;
    }
    
    grid[row][column] = '0';
    isIsland(grid, row - 1, column); // 上
    isIsland(grid, row, column + 1); // 右
    isIsland(grid, row + 1, column); // 下
    isIsland(grid, row, column - 1); // 左
}
```
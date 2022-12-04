# 54 - Spiral Matrix

* [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

## Related Topics
* Array
* Matrix
* Simulation

## Well Solution
解題邏輯：
![](/images/LeetCode/54-1.png)

```java
public static List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> returnList = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) {
        return returnList;
    }

    // 定義 L,R、T,B 的邊界
    int left = 0, right = matrix[0].length;
    int top = 0, bottom = matrix.length;

    // 結束條件：l == r && t == b
    while (left < right && top < bottom) {

        for (int i = left; i < right; i++) { // run first row
            returnList.add(matrix[top][i]);
        }
        top++;

        for (int i = top; i < bottom; i++) { // run last column
            returnList.add(matrix[i][right - 1]);
        }
        right--;

        if(left >= right || top >= bottom) { // 兩組其中一個條件到達就不往下跑
            break;
        }
        
        for (int i = right - 1; i >= left; i--) { // run last row back
            returnList.add(matrix[bottom - 1][i]);
        }
        bottom--;

        for (int i = bottom - 1; i >= top; i--) { // run first column back
            returnList.add(matrix[i][left]);
        }
        left++;
    }

    return returnList;
}
```

## Second Try
大部分都有自己想出來，不過那個等號 debug de 很久xD

![](/images/LeetCode/54-2.png)

```java
public List<Integer> spiralOrder(int[][] matrix) {

    int left = 0, right = matrix[0].length - 1;
    int top = 0, bottom = matrix.length - 1;

    List<Integer> result = new ArrayList<>();

    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;

        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;

        for (int i = right; i >= left; i--) {
            result.add(matrix[bottom][i]);
        }
        bottom--;

        for (int i = bottom; i >= top; i--) {
            result.add(matrix[i][left]);
        }
        left++;
    }
    return result;
}
``` 

## 參考
* https://www.youtube.com/watch?v=BJnMZNwUk1M
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

## 參考
* https://www.youtube.com/watch?v=BJnMZNwUk1M
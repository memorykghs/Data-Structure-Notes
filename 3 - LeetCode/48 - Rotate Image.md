# 48 - Rotate Image

* [Rotate Image](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/)

## Related Topics
* Array

## My Solution
#### Method 1
解題思維：
1. 先將 `matrix[i][j]` 與 `matrix[j][i]` 對調
2. 再將每一個 row 的 matrix 順序進行 reverse

![](/images/LeetCode/48-1.png)

須注意：
* 將 `matrix[i][j]` 與 `matrix[j][i]` 對調時，內層的 for 迴圈是從 `int j = i` 開始，如果從 `int j = 0` 開始，那麼到最下面的時候陣列又會被換回來原本的順序。

![](/images/LeetCode/48-2.png)

```java
class Solution {
    public void rotate(int[][] matrix) {
        // 先對稱翻轉
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix[i].length; j++) { // 對角線上的不換
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// 再 reverse 順序
		for (int z = 0; z < matrix.length; z++) {
			int x = 0;
			int y = matrix.length - 1;

			while (x < y) {
				int temp = matrix[z][x];
				matrix[z][x] = matrix[z][y];
				matrix[z][y] = temp;
				x++;
				y--;
			}
		}
    }
}
```

#### Method 2
```java
public void rotate(int[][] matrix) {
	/*
		* can not use any extra space, just modify the original matrix
		*/

	int left = 0, right = matrix.length - 1;

	while (left < right) {
		for (int i = 0; i < right; i++) {
			int top = left, bottom = right;

			// save the top left
			int topLeft = matrix[top][left + i];

			// move bottom left into top left
			matrix[top][left + i] = matrix[bottom - i][left];

			// move bottom right into bottom left
			matrix[bottom - i][left] = matrix[bottom][right - i];

			// move top right into bottom right
			matrix[bottom][right - i] = matrix[top + i][right];

			// move top left into top right
			matrix[top + i][right] = topLeft;
		}
		right--;
		left++;
	}
}
```

## 參考
* https://ithelp.ithome.com.tw/articles/10233951

#### 影片
* https://www.youtube.com/watch?v=fMSJSS7eO1w
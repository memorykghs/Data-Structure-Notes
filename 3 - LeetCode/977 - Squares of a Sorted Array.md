# 977 - Squares of a Sorted Array

* [Squares of a Sorted Array](quares-of-a-sorted-array/)

## Related Topics
* Array
* Two Pointers
* Sorting

## My Solution
有點想用類似冒泡排序法的方始進行排序，不過因為還要比較平方，感覺方向有點錯QQ

```java
public int[] sortedSquares(int[] nums) {
    
    int max = 0;
    int[] result = new int[nums.length];
    
    for (int i = 0; i < nums.length - 1; i++) {

        max = nums[i + 1] * nums[i + 1];
        int current = nums[i] * nums[i];

        if (current > max) {
            result[i] = max;
            max = current;

        } else if (current < max) { // current < max || current == max
            result[i] = current;

        }
    }

    return result;
}
```

## Well Solution
有三個限制條件：
* `1 <= nums.length <= 104`
* `-104 <= nums[i] <= 104`
* `nums` is sorted in non-decreasing order.

漏看了最後一個限制條件，難怪怎麼想都怪怪的。

由於是非遞減數列，所以頭尾兩端的數字在取絕對值後，比起在中間的值只會越來越大，所以使用 Two Pointers 方法，一個從頭開始，一個從尾部開始，比較平方之後哪個值最大。

![](/images/LeetCode/977-1.png)

```java
public static int[] sortedSquares(int[] nums) {

    int[] result = new int[nums.length];
    int start = 0;
    int last = nums.length - 1;
    
    /*
     * 使用類似冒泡排序法，最多需要排序 n - 1 次
     */
    for (int n = nums.length - 1; n >= 0; n--) {
        if(Math.abs(nums[start]) > Math.abs(nums[last])){
            result[n] = nums[start] * nums[start];
            start++;
        }else {
            result[n] = nums[last] * nums[last];
            last--;
        }
    }
    return result;
}
```

本來想要如法炮製從最小的開始放，但也是因為 non-decreasing 的限制，無法決定哪個數字最小，還是得由最大的開始放。
```java
public static int[] sortedSquares(int[] nums) {

		int[] result = new int[nums.length];
		int start = 0;
		int last = nums.length - 1;
		
		for (int n = 0; n < nums.length; n++) {
			if(Math.abs(nums[start]) < Math.abs(nums[last])){
				result[n] = nums[start] * nums[start];
				start++;
			}else {
				result[n] = nums[last] * nums[last];
				last--;
			}
		}

		return result;
	}
```

## 參考
* https://leetcode.com/problems/squares-of-a-sorted-array/discuss/221922/Java-two-pointers-O(N)
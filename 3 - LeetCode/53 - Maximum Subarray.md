# 53 - Maximum Subarray

* [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

## Related Topics
* Array
* Divide and Conquer
* Dynamic Programming

## My Solution
![](/images/LeetCode/53-1.png)

## Well Solution

![](/images/LeetCode/53-2.png)

```java
public int maxSubArray(int[] nums) {
        
    int result = nums[0]; // 最後回傳回去的和
    int subSum = 0; // 當前最大的和，依照每個迭代的數字改變
    
    for(int x : nums) {
        if(subSum < 0) { // 當家上的數字小於 0 時，代表現在的數字和不是最大的，所以歸零重新計算
            subSum = 0;
        }
        
        subSum += x;
        result = Math.max(result, subSum);
    }
    
    return result;
}
```

後來又寫到了一次，覺得動態規劃的方式比較好。
```java
public int maxSubArray(int[] nums) {
    if(nums.length == 0) {
        return 0;
    }
    
    // base case
    int previousSum = nums[0];
    int currentSum = 0;
    int result = previousSum;
    
    for(int i = 1; i < nums.length; i++) {
        // dp[i] = Math.max(nums[i], nums[i] + dp[i-1]
        currentSum = Math.max(nums[i], nums[i] + previousSum);
        previousSum = currentSum;
        
        // 計算最大結果
        result = Math.max(result, currentSum);
    }
    
    return result;
}
```

## 參考
* https://www.youtube.com/watch?v=5WZl3MMT0Eg
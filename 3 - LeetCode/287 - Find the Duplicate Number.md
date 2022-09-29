# 287 - Find the Duplicate Number

* [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

## Related Topics
* Array
* Two Pointers
* Binary Search
* Bit Manupulation

## My Solution
原本想用 O(<sup>2</sup>) 解決，發現竟然可以用 Binary Search。

## Well Solution
題目有幾個特定的限制：
1. `1 <= nums[i] <= n`
2. There is only one repeated number in nums, return this repeated number.
3. 時間複雜度不能超過 O(<sup>2</sup>)
4. 不能變動原 array，等於無法排序
5. 只能使用 O(1) 的空間，等於是不能用新的 array

由於第一個限制，所以整體可以當作是在打彈珠。彈珠檯有 10 個格子，打了 11 顆，代表勢必有一個格子有兩顆。用這種 Binary Search 的方式來找只需要 O(n log n)。

```java
public int findDuplicate(int[] nums) {
    // uses binary search
    int left = 1;
    int right = nums.length - 1;
    
    while(left < right) {
        
        int mid = left + (right - left) / 2;
        int count = 0;
        
        for(int num : nums) {
            if(num <= mid) {
                count++;
            }
        }
        
        if(count <= mid) { // 數量右邊多，故區間為 [mid + 1, n]
            left = mid + 1;
        } else { // 數量左邊多，故區間為 [ 0, mid]
            right = mid;
        }
    }
    
    return left;
}
```

## 參考
* https://www.cnblogs.com/grandyang/p/4843654.html
# 238 - Product of Array Except Self

* [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## Related Topics
* Array
* Prefix Sum

## My Solution
題目限制只能使用 O(n) 的時間複雜度，想不出來。

## Well Solution
智商暫時不足...

![](/images/LeetCode/238-1.png)

```java
public int[] productExceptSelf(int[] nums) {

    int[] product = new int[nums.length];
    product[0] = 1;

    for (int i = 1; i < nums.length; i++) {
        product[i] = product[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        product[i] = product[i] * right;
        right *= nums[i];
    }
    
    return product;
}
```

## 參考
* https://ithelp.ithome.com.tw/articles/10247080
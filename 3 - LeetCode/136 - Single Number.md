# 136 - Single Number

* [Single Number](https://leetcode.com/problems/single-number/)

## Related Topics
* Array
* Bit Manipulation

## My Solution
限制：
* linear runtime complexity 
* only constant extra space

原本想用之前看到的絕對值方式，將該位置的值變成負數 但這題沒有特別限制 `nums[i]` 的值會小於 `nums.length`，所以數值大小可能會超過 index。

## Well Solution
使用位元操作，快速解決XD。

使用 `XOR` 的位元操作邏輯做運算，大致規則像下面這兩點：
* `0 ^ N = N`
* `N ^ N = 0`

```java
public int singleNumber(int[] nums) {
    int answer = 0;
    for(int i = 0; i < nums.length; i ++) {
        answer ^= nums[i];
    }
    
    return answer;
}
```

## 參考
* https://leetcode.com/problems/single-number/discuss/43201/Easy-Java-solution-(tell-you-why-using-bitwise-XOR)
* https://www.educative.io/blog/bit-manipulation-in-java
# 1475 - Final Prices With a Special Discount in a Shop

* [Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/)

## Related Topics
* Array
* Stack
* Monotonic Stack

## My Solution
一開始看想不出來為什麼用 stack。
關鍵在於：
* 放進 stack 的是 index 而不是 value
* 所以最先放進去的是離當下這圈最近的 index

## Well Solution
```java
public int[] finalPrices(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < prices.length; i++) {
        while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
            prices[stack.pop()] -= prices[i];
        }
        stack.add(i);
    }
    return prices;
}
```

## 參考
* https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/discuss/685390/JavaC%2B%2BPython-Stack-One-Pass*
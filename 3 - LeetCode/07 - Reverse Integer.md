# 07 - Reverse Integer

* [Reverse Integer](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880)

## Related Topics
* Strings

## My Solution
有點冗，而且沒有考慮到負號的問題，還有數字過大過小溢位的部分。

```java
public int reverse(int x) {
    String[] arr = x > 0 ? String.valueOf(x).split("") : String.valueOf(-1 * x).split("");
    int i = 0;
    int result = 0;
    int times = 1;

    while (i < arr.length) {
        result += Integer.parseInt(arr[i]) * times;
        
        i++;
        times = times * 10;
    }
    
    result = x > 0 ? result : -1 * result;
    
    return result;
}
```

## Well Solution

![](/images/LeetCode/7-2.png)

```java
public int reverse(int x) {
		
    int result = 0;
    
    while(x != 0) {
        
        // 不用特別處理負號，因為一開始就會乘到
        int tail = x % 10; // ex. -33 % 10 = -3
        int newResult = result * 10 + tail;
        
        // 判斷是否超過 Integer 上限溢位
        if((newResult - tail) / 10 != result) {
            return 0;
        }
        
        // 把以處理的尾數砍掉
        x = x / 10;
        result = newResult;
    }
    
    return result;
}
```

## 參考
* https://www.youtube.com/watch?v=tm1Yrb_SfBM
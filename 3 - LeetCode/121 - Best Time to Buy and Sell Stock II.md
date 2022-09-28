# 121 - Best Time to Buy and Sell Stock

* [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## Related Topics
* Array
* Dynamic Programming

## My Solution
```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int total = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(i == 0){
                buy = prices[i];
                
            }else if(prices[i] > buy){
                total += (prices[i] - buy); 
                buy = prices[i];
                
            }else if(buy > prices[i]){
                buy = prices[i];
            }
               
        }
        return total;
    }
}
```

## Well Solution
```java
public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
        return 0;
    }

    int maxProfitHere = 0;
    int maxProfitSoFar = 0;
    for (int i = 1; i < prices.length; i++) {
        maxProfitHere = Math.max(0, maxProfitHere + prices[i] - prices[i - 1]);
        maxProfitSoFar = Math.max(maxProfitSoFar, maxProfitHere);
    }

    return maxProfitSoFar;
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/discuss/1569081/Java-Simple-and-Clean-DP-solutions-for-all-6-Buy-and-Sell-Stock-questions-on-LeetCode
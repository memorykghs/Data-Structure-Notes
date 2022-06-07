# Best Time to Buy and Sell Stock II
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

#### Example
```
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```

```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```

#### Constraints:
* `1 <= prices.length <= 3 * 104`
* `0 <= prices[i] <= 104`

#### My Solution
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

#### Well Solution
```java

```
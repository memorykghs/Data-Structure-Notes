# 322 - Coin Change

* [Coin Change](https://leetcode.com/problems/coin-change/)

## Related Topics
* Dynamic Programming
* Array
* Breadth-First Search
* Memorize (個人覺得有)

## My Solution
本來想說從最大的往回開始推，判斷方式是由最大的面額開始往回推：
```
amount / coin != 0 → 代表可以使用此面額
amount / coin == 0 && amount % coin != 0 → 代表當前的面額比總金額大，要換下一個
```

但這樣實作中會遇到一些問題：
###### 問題一
```
coins = [1 ,3, 4, 5]
amount = 7
```

其實 `3 + 4` 這個解會比 `1 + 1 + 5` 來的好，但是如果由最大面額開始往回推，就沒有辦法推到這個結果。

###### 問題二
需要特別排除特殊案例，例如：
```
coins = [3, 5]
amount = 7
```

由面額最大的往前推，但是跑道最後面會發現當前沒有任何面額可以完整的兌換完畢，所以要回傳 `-1`。

###### 寫法
```java
public static int coinChange(int[] coins, int amount) {
		
    Arrays.sort(coins);

    int results = 0;
    int i = coins.length - 1;

    while (i >= 0) { // i 代表面額

        if (amount == 0) {
            break;
        }

        int coin = coins[i];
        int mathResult = amount / coin;
        if (mathResult > 0) {
            // 代表可以被兌換
            results += mathResult;
            amount -= coin * mathResult;
            i--;

        } else if (mathResult == 0 && amount % coin != 0) {
            // 代表此輪硬幣面額已經金額大，換小一點的面額
            i--;
        }
    }

    if (amount > 0) {
        results = -1;
    }

    return results;
}
```

## Well Solution
解題方式可以看影片。

```java
public int coinChange(int[] coins, int amount) {
        
    if(amount == 0) {
        return 0;
    }

    // cache dp
    long[] dp = new long[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE); // 先塞值
    dp[0] = 0;

    for (int amt = 1; amt <= amount; amt++) {
        for (int coin : coins) {
            if (amt - coin >= 0) {
                dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
            }
        }
    }

    if (dp[amount] == Integer.MAX_VALUE) {
        return -1;
    }

    return (int)dp[amount];
}
```

## 參考
* https://www.geeksforgeeks.org/coin-change-dp-7/

#### 影片
* https://www.youtube.com/watch?v=H9bfqozjoqs
* https://www.youtube.com/watch?v=Mjy4hd2xgrs
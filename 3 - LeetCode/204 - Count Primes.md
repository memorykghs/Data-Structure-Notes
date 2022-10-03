# 204 - Count Primes

* [Count Primes](https://leetcode.com/problems/count-primes/)

## Related Topics
* Array
* Math
* Enumeration
* Math Theory

## My Solution
原本想要用一個 Array 記所有質數，但是這樣有點難以排除其他數字是不是質數。所以改由下面的做法，將不是質數的記在一個 boolan Array 裡。

## Well Solution
因為不需要列出有哪些質數，所以只需要使用 boolean array 跟計算有多少即可。

```java
public int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    
    int count = 0;
    for(int i = 2; i < n; i++) {
        if(notPrime[i] == false) { // 表示還沒有被處理過或是不是質數
            count++;
            for(int j = 2; i * j < n; j++) { // 處理當前數字的倍數，一併更改為 true
                notPrime[i * j] = true;
            }
        }
    }
    
    return count;
}
```

LeetCode 上有一個很棒的 GIF 展現這個解法做的事情：一一排如當前迴圈 `i` 的倍數，判斷不通過的就是質數了。

![](https://leetcode.com/static/images/solutions/Sieve_of_Eratosthenes_animation.gif)


[GIF 來源](https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution)

> Q.   同場加映，承上題，將所有比 n 小的質數都列出來該如何解決? 

這是目前想到的解法惹。

```java
public static List<Integer> findPrimeNumber(int n) {
    /*
        * n = 1, 0 
        * n = 2, 0 
        * n = 3, 2 
        * n = 4, 2 & 3 
        * n = 5, 2 & 3 
        * n = 6, 2 & 3 & 5
        */

    if (n < 3) {
        return null;
    }

    boolean[] notPrimes = new boolean[n];
    notPrimes[0] = true;
    notPrimes[1] = true;
    
    List<Integer> result = new ArrayList<>();
    
    for (int i = 2; i < n; i++) {
        if (notPrimes[i]) { // 在 notPrimes 裡面的就不是質數
            continue;

        } else {
            
            // 計算後面可以被當前數字 i 整除的，就先丟到 notPrimes 裡面
            for(int j = i; j * i < n; j++) {
                notPrimes[i * j] = true;
            }
            
            // 確認是否為質數的條件：平方根小於 n 但無法被 n 整除
            if(i * i < n && n % i == 0) {
                notPrimes[i] = true;
            } else {
                result.add(i);
            }
        }
    }
    
    return result;
}
```

## 參考
* https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
* https://hannahpun.gitbook.io/leetcode-note/math/204-count-primes
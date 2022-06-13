# 1641 - Count Sorted Vowel Strings

* [Remove Duplicates from Sorted Arra](https://leetcode.com/problems/count-sorted-vowel-strings/)

## Related Topics
* Dynamic Programming


## My Solution
```java
package leetCode.medium;

import java.util.LinkedList;
import java.util.List;

public class CountSortVowelStrings_1641 {

	public static String[] VOWEL = { "a", "e", "i", "o", "u" };
	
	public static String VOWEL_STR = "aeiou";

	public static void main(String[] args) {
		System.out.print(countVowelStrings(2));
	}

	public static int countVowelStrings(int n) {

		if (n < 1) {
			return 0;
		}

		int k = n;
		List<String> resultList = new LinkedList<>();

		// 遞迴
		recursive(k, "", resultList);

		return resultList.size();
	}

	private static void recursive(int k, String str, List<String> resultList) {
		
		for (int i = 0; i < 5; i++) { // 一圈5個

			if (!"".equals(str) && VOWEL_STR.indexOf(str.charAt(str.length() - 1)) > i) { // 前一個字母順序較後面的話，跳過
				continue;
			}

			if (k == 1) { // 最底層的一圈
				System.out.println(str + VOWEL[i]);
				resultList.add(str + VOWEL[i]);

			} else {
				// 遞迴
				recursive(k - 1, str + VOWEL[i], resultList);

			}
		}
	}
}
```

![](/images/LeetCode/1641-1.png)
嗚嗚嗚嗚嗚。
嗚嗚嗚嗚嗚嗚嗚嗚。

## Well Solution
不需要將實際的結果加入 List 內，只需要依照規則，將不需要的結果剔除即可。

`dp[n][k]` means the number of strings constructed by at most k different characters.

If k = 1, use only u
If k = 2, use only o,u
If k = 3, use only i,o,u
If k = 4, use only e,i,o,u
If k = 5, use only a,e,i,o,u

```java
public static int countVowelStrings(int n) {
    
    int[][] dp = new int[n + 1][6];
    
    for(int i = 1; i <= n; ++i) { // 層數
        for(int k = 1; k < 6; ++k) { // 一圈5個英文
            
            dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
        }
    }
    
    return dp[n][5];
}
```

###### 解析
假設 `n = 2`，代表我們會有一個 3 x 6 的二維陣列。

因為 `for` 迴圈中是 `++i`，所以進入第一圈的時候，`i` 的值是 1，直到跑完第一次的迴圈才會加 1。
```java
 for(int i = 1; i <= n; ++i) { // 第一圈 i = 2
    ...
 }
```
同理，進入第二個 `for` 迴圈，`k` 的值為 1。還沒開始之前，矩陣是長這個樣子的：

```
| 0 0 0 0 0 0 |
| 0 ? ? ? ? ? |
| 0 ? ? ? ? ? |
```

```
i = 2
    k = 2 ⇒ dp[1][1] = dp[1][0] + ( 1 > 1 ? dp[1][2] : 1)
          ⇒ dp[1][1] = 1
```

當 `k = 1` 這圈跑完，陣列如下：
```
| 0 0 0 0 0 0 |
| 0 1 ? ? ? ? |
| 0 ? ? ? ? ? |
```

而 `k = 2` 結束時，狀況如下：
```
| 0 0 0 0 0 0 |
| 0 1 2 ? ? ? |
| 0 ? ? ? ? ? |
```
以此類推。

整體的過程：

![](/images/LeetCode/1641-2.png)

```
i = 1
    k = 2 ⇒ dp[1][1] = dp[1][0] + ( 1 > 1 ? dp[1][2] : 1)
          ⇒ dp[1][1] = 1
    k = 3 ⇒ dp[1][2] = dp[1][1] + 1
          ⇒ dp[1][1] = 2
    k = 3 ⇒ dp[1][3] = dp[1][2] + 1
          ⇒ dp[1][3] = 3
    k = 4 ⇒ dp[1][4] = dp[1][3] + 1
          ⇒ dp[1][4] = 4
    k = 5 ⇒ dp[1][5] = 5

i = 2
    k = 1 ⇒ dp[2][1] = dp[2][0] + ( 2 > 1 ? dp[1][1] )
          ⇒ dp[2][1] = 1
    k = 2 ⇒ dp[2][2] = 3
    k = 3 ⇒ dp[2][3] = 6
    k = 4 ⇒ dp[2][4] = 10
    k = 5 ⇒ dp[2][5] = 15

result：
| 0   0   0   0   0   0 |
| 0   1   2   3   4   5 |
| 0   1   3   6  10  15 |
```


## 參考
紀錄一下某位大大寫了很多解法：https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC%2B%2BPython-DP-O(1)-Time-and-Space
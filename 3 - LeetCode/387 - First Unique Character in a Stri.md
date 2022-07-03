# 387 - First Unique Character in a String
* [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

## Related Topics
* String
* Counting
* Queue
* Hash Table

## My Solution
![](/images/LeetCode/387-1.png)

## Well Solution
解題思維：
1. 建立一個長度為 26 的陣列
2. 使用 ASCII code，每一個字母的 ASCII code 減掉 `a` 的，可以得到陣列 index ( `s.charAt(i) - 'a'` 主要是為了轉換為數字，而字元轉換成數字會得到 ASCII code 的數字 )
3. 遍歷陣列的並計算該字元出現的次數
4. 對傳入的單字跑回圈，對應到陣列的數字是 1 的話，即為第一個不重複的字

```java
public int firstUniqChar(String s) {
    int[] frequency = new int[26];

    // 先把每個英文字出現的字數丟到 frequency 中
    for (int i = 0; i < s.length(); i++) {

        // ASCII Code a = 97
        // 因為 int 預設是 0，將該 index 的值+ 1
        frequency[s.charAt(i) - 'a']++;
    }

    // 對 frequency 遍歷，遇到第一個是 1 的值就回傳
    for (int i = 0; i < s.length(); i++) {
        if (frequency[s.charAt(i) - 'a'] == 1) { // 依照文字順序轉換到 frequency
            return i;
        }
    }
    
    return -1;
}
```

## 參考
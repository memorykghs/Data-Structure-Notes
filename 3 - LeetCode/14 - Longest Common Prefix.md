# 14 - Longest Common Prefix

* [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

## Related Topics
* String

## My Solution
![](/images/LeetCode/14-1.png)

## Well Solution
```java
public static String longestCommonPrefix(String[] strs) {

    String prefix = strs[0];

    for (String str : strs) {

        // 因為是 prefix，所以找的話 index 是 0
        while (str.indexOf(prefix) != 0) { 
            // 找不到的話就一直移掉最後一個英文字母
            // 直到 prefix 符合當前的英文單字
            prefix = prefix.substring(0, prefix.length() - 1);
        }
    }

    return prefix;
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/discuss/6910/Java-code-with-13-lines
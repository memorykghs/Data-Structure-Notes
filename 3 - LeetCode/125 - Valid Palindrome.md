# 125 - Valid Palindrome

* [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## Related Topics
* Two Pointers
* String


## My Solution
![](/images/LeetCode/125-1.png)

## Well Solution
解題思維：
* 先全部轉成小寫
* Two Pointer 一個由前面，一個由後面靠近
* 使用 Character 的 `isLetterOrDigit()` 方法判斷是不是英文或數字 ( 原本想用 Regex 來判斷的說 )

```java
public static boolean isPalindrome(String s) {

    // 先全部轉成小寫
    s = s.toLowerCase();

    int i = 0;
    int j = s.length() - 1;
    char[] sArr = s.toCharArray();

    while (i < j) {
        if (!Character.isLetterOrDigit(sArr[i])) { // 如果遇到的不是英文字母或是數字 i++
            i++;
        } else if (!Character.isLetterOrDigit(sArr[j])) { // 如果遇到的不是英文字母或是數字 j--
            j--;
        } else if (sArr[i] != sArr[j]) {
            return false;
        } else {
            i++;
            j--;
        }
    }

    return true;
}
```

## 參考
* https://www.youtube.com/watch?v=jJXJ16kPFWg
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/discuss/40029/Accepted-pretty-Java-solution(271ms)
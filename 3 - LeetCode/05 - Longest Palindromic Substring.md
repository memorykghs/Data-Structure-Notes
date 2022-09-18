# 5 - Longest Palindromic Substring
* [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)


## Related Topics
* String
* Dynamic Programming

## My Solution
好難，想不出來QQ

## Well Solution
直接看了 LeetCode 的 Solution。

### LeetCode Solution
* [Longest Palindromic Substring (Solution)](https://leetcode.com/problems/longest-palindromic-substring/solution/)

#### Summary
> This article is for intermediate readers. It introduces the following ideas: Palindrome, Dynamic Programming and String Manipulation. Make sure you understand what a palindrome means. A palindrome is a string which reads the same in both directions. For example, SS = "aba" is a palindrome, SS = "abc" is not.

此題跟 Palindrome ( 迴文 )、Dynamic Programming 以及 String 的操作有關係。Palindrome 的定義，舉個例子，像是 SS = "aba" 就是一個迴文，SS = "abc" 就不是。

---

#### Solution
##### Approach 1: Longest Common Substring
###### Common mistake

Some people will be tempted to come up with a quick solution, which is unfortunately flawed (however can be corrected easily):

> Reverse S and become 'S. Find the longest common substring between S and 'S , which must also be the longest palindromic substring.
將原本的 S reverse 為一個新的字串 'S。然後在這兩個字串中 substring，找到最長的迴文字串。

這看似是可行的，不過我們來看看幾個例子。

```
/* Ex.1 */
S = "caba", S = "abac"
```
最長的字串是 "aba"，此時答案是正確的。

```
/* Ex.2 */
S = "abacdfgdcaba", 'S = "abacdgfdcaba"
```
在這個例子中最長的相同字串是 "abacd"，很明顯的它不是一個迴文。

##### Algorithm

We could see that the longest common substring method fails when there exists a reversed copy of a non-palindromic substring in some other part of SS. To rectify this, each time we find a longest common substring candidate, we check if the substring's indices are the same as the reversed substring's original indices. If it is, then we attempt to update the longest palindrome found so far; if not, we skip this and find the next candidate.

This gives us an O(n<sup>2</sup>) Dynamic Programming solution which uses O(n<sup>2</sup>) space (could be improved to use O(n) space). Please read more about Longest Common Substring here.

---

#### Approach 2: Brute Force
The obvious brute force solution is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome.

##### Complexity Analysis

* Time complexity : O(n<sup>3</sup>). Assume that nn is the length of the input string, there are a total of $(\frac{{\rm n}}{2}) = \frac{n(n-1)}{2}​$ such substrings (excluding the trivial solution where a character itself is a palindrome). Since verifying each substring takes O(n) time, the run time complexity is O(n<sup>3</sup>).

* Space complexity : O(1).

---

#### Approach 3: Dynamic Programming
To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j) as following:

$P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\ \text{false,} &\quad\text{otherwise.} \end{cases}$

Therefore,

$P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )$

The base cases are:

$P(i, i) = trueP(i,i)=true$

$P(i, i+1) = ( S_i == S_{i+1} )$

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

##### Complexity Analysis
* Time complexity : O(n<sup></sup>). This gives us a runtime complexity of O(n<sup></sup>).
* Space complexity : O(n<sup></sup>). It uses O(n<sup></sup>) space to store the table.

###### Additional Exercise
Could you improve the above space complexity further and how?

---

#### Approach 4: Expand Around Center
In fact, we could solve it in O(n<sup></sup>) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only $2^n - 1$ such centers.

You might be asking why there are $2^n - 1$ but not nn centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.

#### Implementation
```java
public String longestPalindrome(String s) {
    if(s == null || s.length() < 1) { // 沒有重複的字，無法構成迴文
        return "";
    }
    
    int start = 0, end = 0;
    
    for(int i = 0; i < s.length(); i++) {
        int length1 = expandAroundCenter(s, i, i);
        int length2 = expandAroundCenter(s, i, i + 1);
        int length = Math.max(length1, length2);
        
        if(length > end - start) {
            start = i - (length - 1) / 2;
            end = i + length / 2;
        }
    }
    
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int l = left;
    int r = right;
    while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
    }
    
    return r - l - 1;
}
```

## 參考
#### 影片
* https://www.youtube.com/watch?v=XYQecbcd6_c
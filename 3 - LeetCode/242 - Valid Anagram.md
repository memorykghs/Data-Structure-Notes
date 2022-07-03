# 242 - Valid Anagram

* [Valid Anagram](https://leetcode.com/problems/valid-anagram/)

## Related Topics
* String
* Sorting
* Hash Table

## My Solution
```java
public static boolean isAnagram(String s, String t) {

    if(s.length() != t.length()) {
        return false;
    }

    String[] sArr = s.split("");
    String[] tArr = t.split("");

    Arrays.sort(sArr);
    Arrays.sort(tArr);

    for (int i = 0; i < s.length(); i++) {
        if (!sArr[i].equals(tArr[i])) {
            return false;
        }
    }
    
    return true;
}
```

## Well Solution
解題思維：
1. 一樣是透過 ASCII code，遍歷兩個字串，並對同一個 int array 進行操作，一個加一，一個減一
2. 最後遍歷 int array，如果有一個數字不是 0 的話代表字母沒有重複

```java
public static boolean isAnagram(String s, String t) {
		
    int[] alphabat = new int[26];
    
    for(int i = 0; i < s.length(); i++) {
        alphabat[s.charAt(i) - 'a']++;
    }
    
    for(int i = 0; i < t.length(); i++) {
        alphabat[t.charAt(i) - 'a']--;
    }
    
    for(int i : alphabat) {
        if(i != 0) {
            return false;
        }
    }
    
    return true;
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
# 28 - Implement strStr()

* [Implement strStr()](https://leetcode.com/problems/implement-strstr/)

## Related Topics
* Two Pointers
* String
* String Matching

## My Solution
```java
public static int strStr(String haystack, String needle) {
		
    if(haystack.length() < needle.length()) {
        return -1;
    }

    String[] hay = haystack.split("");
    String[] nee = needle.split("");
    int i = 0; // haystack index
    int j = 0; // needle index
    int index = -1;

    while (i < haystack.length()) {

        // 找到與 needle 開頭相同的字母的話
        if (hay[i].equals(nee[0])) {
            
            index = i;

            while (j < nee.length) {
                if (!nee[j].equals(hay[i])) {
                    index = -1;
                }
                i++;
                j++;
            }
        }
        
        i++;
    }

    return index;
}
```

## Well Solution
* time complexity = `O(m * n)`，其中 `m` 為 `haystack` 長度，`n` 為 `needle` 長度
* space complexity = `O(1)`，因為沒有創造其他物件

```java
public static int strStr(String haystack, String needle) {
		
    if(needle.length() == 0) { // edge case: "", "" / "str", ""
        return -1;
    }

    for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
        for(int j = 0; j < needle.length(); j++) {
            
            // 一旦發現有相同的，就進入判斷
            // charAt(i + j) 是同步讓 haystack 保持連貫字母並做判斷
            if(haystack.charAt(i + j) != needle.charAt(j)) {
                break;
            }
            
            // 因為 Two Pointers，外部的 i 沒有被更動，直接回傳即可
            if(j == needle.length() - 1) {
                return i;
            }
        }
    }
    
    return -1;
}
```

## 參考
* https://www.youtube.com/watch?v=Gjkhm1gYIMw
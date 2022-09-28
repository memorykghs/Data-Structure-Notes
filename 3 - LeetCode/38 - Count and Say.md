# 38 - Count and Say

* [Count and Say](https://leetcode.com/problems/count-and-say/)

## Related Topics
* String

## My Solution
原題的意思就是用一個新的字符串描述上一個字符串，用數字表示上一個：
```
當 n=1 時：輸出 1
當 n=2 時，解釋 1，有 1 個 1 ，表示為 11
當 n=3 時，解釋上一個 11，有 2 個 1，表示為 21 ( 註意相同數字的描述 )
當 n=4 時，解釋上一個 21，有 1 個 2、一個 1，表示為 1211
當 n=5 時，解釋上一個 1211，有 1 個 1、1 個 2，2 個 1，表示為 111221
當 n=6 時，解釋上一個 111221，有 3 個 1，2 個 2，1 個 1，表示為 312211
```

本來想用遞迴，但是爆掉了。

```java
public static String countAndSay(int n) {

    StringBuilder sb = new StringBuilder();
    String[] cache = new String[n];
    
    handle(n, cache, sb);

    return cache[n];
}

private static String handle(int n, String[] cache, StringBuilder sb) {

    // extreme case
    if (n == 1) {
        cache[n] = "1";
        return cache[n];
    }

    char[] arr = handle(n - 1, cache, sb).toCharArray();
    char current = arr[0];
    int count = 0;

    for (char c : arr) {
        if (current == c) {
            count++;

        } else {
            sb.append(count).append(current);
            count = 1;
            current = c;
        }
    }

    cache[n] = sb.toString();
    sb.setLength(0);

    return cache[n];
}
```

## Well Solution
其實寫法差不多，只是把控制像換到別的地方。

```java
public static String countAndSay(int n) {

    StringBuilder sb = new StringBuilder();
    String s = "1";
    
    for(int i = 1; i < n; i++) {
        s = handle(s, sb);
    }

    return s;
}

private static String handle(String s, StringBuilder sb) {
    
    sb.setLength(0);

    char[] arr = s.toCharArray(); 
    int count = 0;
    char current = arr[0];

    for (char c : arr) {
        if (current == c) {
            count++;

        } else {
            sb.append(count).append(current);
            count = 1;
            current = c;
        }
    }

    sb.append(count).append(current);
    return sb.toString();
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/4153/discuss/16040/Straightforward-Java-Solution

* https://www.796t.com/content/1532842761.html
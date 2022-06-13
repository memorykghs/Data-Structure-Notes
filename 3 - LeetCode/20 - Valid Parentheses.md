# 20 - Valid Parentheses

* [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Related Topics
* String
* Stack

## My Solution
一開始的想法，但是很難做，光是字串拼接就有可能出問題。
![](/images/LeetCode/20-1.png)

## Well Solution
解題邏輯：
1. 將成對的符號以 HashMap 封裝
2. 對 String.toCharArray 跑回圈
3. 當 HashMap 裡面有這個 key 值，將對應的 value 放入 Stack 中
4. 跑道後半部，將不再出現有的 key 值時，比對 Stack 中與當前迭代的值是否相同，相同時將 Stack 中的值給去除
5. 最後，如果 Stack 中仍有值，代表這些符號沒有成對

![](/images/LeetCode/20-2.png)

```java
public boolean isValid(String s) {

    Stack<Character> stack = new Stack<>(); // 放 String 中的文字

    Map<Character, Character> pairMap = new HashMap<>();
    pairMap.put('{', '}');
    pairMap.put('(', ')');
    pairMap.put('[', ']');

    for (char c : s.toCharArray()) {

        if (pairMap.containsKey(c)) {
            stack.push(pairMap.get(c)); // 用 stack 放，到時候一個一個從前面拿出來即可
            
        } else if (stack.isEmpty() || stack.pop() != c) { // char 用 != 比較，跟 String 不同
            return false;
        }
    }

    return stack.isEmpty();
}
```

## 參考
* https://www.youtube.com/watch?v=WTzjTskDFMg
* https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
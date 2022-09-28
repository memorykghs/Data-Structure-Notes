# 1047 - Remove All Adjacent Duplicates In String

* [Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

## Related Topics
* String 
* Stack

## My Solution
![](/images/DataStructure/1047-1.png)

```java
 public String removeDuplicates(String s) {
        
    if(s == null || s.length() == 0) {
        return "";
    }
    
    Stack<Character> stack = new Stack<>();
    
    char[] arr = s.toCharArray();
    for(char c : arr) {
        if(stack.isEmpty() || stack.lastElement() != c) { // first loop or different char
            stack.add(c);
            
        }else if(stack.lastElement() == c) {
            stack.pop();
        }
    }
    
    StringBuilder sb = new StringBuilder();
    for(char c : stack) {
        sb.append(c);
    }
    
    return sb.toString();
}
```

## 參考
#### 影片
# 03 - Longest Substring Without Repeating Characters

* [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## Related Topics
* String
* Sliding Window

## My Solution
沒有考慮到如果中間出現了兩個一樣的字母就要重新算的部分，所以部分結果會比正解多一個長度。
```java
public static int lengthOfLongestSubstring(String s) {

    Queue<String> queue = new LinkedList<>(); // 放當前最長的字
    String[] arr = s.split("");

    queue.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {

        String str = arr[i];

        if (queue.contains(str)) { // 如果出現重複的

            /*
            1. 判斷下一個是不是同樣的字母
            2. 是的話就替換 (因為字數一樣長)
            3. 不是的話就不換，代表當前的字數較長
            */
            if (queue.peek().equals(str)) {
                queue.poll(); // 把第一個字母拉出來

            }else {
                continue;
            }
        }

        queue.add(str);
    }

    return queue.size();
}
```

## Well Solution

![](/images/LeetCode/3-2.png)

```java
public static int lengthOfLongestSubstring(String s) {
		
    Queue<Character> queue = new LinkedList<>(); // 當前視窗中的字
    int length = 0; // 紀錄當前最長長度
    
    for(char c : s.toCharArray()) {
        // 如果重複的字不是出現在第一位，代表現在的長度全部要重新算
        // 所以需要再跑一個迴圈把字母砍掉，直到當前視窗沒有重複字元
        while(queue.contains(c)) {
            queue.poll();
        }
        
        queue.offer(c);
        length = Math.max(length, queue.size());
    }
    
    return length;
}
```

## 參考
* https://www.youtube.com/watch?v=wiGpQwVHdE0
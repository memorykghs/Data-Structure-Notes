# 141 - Linked List Cycle

* [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/submissions/)

## Related Topics
* Linked List
* Hash Table
* Two Pointers

## My Solution
1. 檢視尾端 `next` 有沒有出現過的 `value`
2. 某個 node 會接到兩個 `next`

&rArr; 代表裡面沒有 node 的 `next` 是 `null`
&rArr; 遇到重複的值代表 `true`

雖然知道但是以為要遇到同一個 node 才算，也就是 `tail` 接回去的 node 才算，但其實只要有遇到重複的就好了，因為不會結束，是個迴圈，其中一個 pointer 比較快就會追上慢的。

## Well Solution
* 使用 Two Pointers 方法，一個一次移動一個 node ( `slow` )，另外一個一次移動兩個 node ( `fast` )
* 運動到龜兔賽跑演算法 ( **Floyd Cycle Detection Algorithm** )

```java
public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        
        if(slow == fast) { // 不用比值，因為比值不準，並沒有說 value 是 unique
            return true;
        }
    }
    
    return false;
}
```

## 參考
* https://matthung0807.blogspot.com/2020/04/floyd-cycle-detection-algorithm-floyd.html
* https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/discuss/44694/Accepted-clean-Java-solution
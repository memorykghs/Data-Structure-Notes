# 234 - Palindrome Linked List

* [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

## Related Topics
* Linked List
* Two Pointers
* Stack
* Recursion

## My Solution
初始想法也是想說找到中位數...但不知道怎麼找。

## Well Solution
1. 一樣利用歸路賽跑演算法找到中間的 node ( `fast` pointer 下一個為 `null` 時 )
2. reverse 另一半的 node
3. 一個從尾端回來 ( 前一步驟 reverse 的 Linked List )，一個從 `head` 開始比對 

```java
public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    // 藉由龜兔賽跑方法找到中位數
    while (fast != null && fast.next != null) {

        fast = fast.next.next; // fast pointer 一次 2 步
        slow = slow.next; // slow pointer 一次 1 步
    }

    // reverse 後半部
    ListNode prev = null;
    while (slow != null) {
        ListNode temp = slow.next;
        slow.next = prev;
        prev = slow;
        slow = temp;
    }
    
    // check palindrome
    ListNode left = head;
    ListNode right = prev;
    while (right != null) {
        if(left.val != right.val) {
            return false;
        }
        
        left = left.next;
        right = right.next;
    }
    
    return true;
}
```

## 參考
* https://www.youtube.com/watch?v=yOzXms1J6Nk
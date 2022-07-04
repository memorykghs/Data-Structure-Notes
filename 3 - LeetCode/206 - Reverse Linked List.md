# 206 - Reverse Linked List

* [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

## Related Topics
* Linked List
* Recursion

## My Solution
因為記憶體參考的關係，一直在迴圈裡面打轉XD

```java
public ListNode reverseList(ListNode head) {

    ListNode current = head;
    ListNode newHead = null;

    while (current.next != null) {

        // 建立新的 head
        newHead = current.next;

        // 紀錄並串聯當前的 head 節點
        ListNode next = new ListNode(current.val);
        newHead.next = next;

        // 原本的 head 往前移動
        current = current.next;
    }

    return newHead;
}
```

## Well Solution
其實 `newHead` 改成 `prevNode` 可能會比較好理解...

![](/images/LeetCode/206-1.png)

```java
public static ListNode reverseList(ListNode head) {
		
    ListNode newHead = null;
    
    while (head != null) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }

    return newHead;
}
```

## 參考
* https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
# 02 - Add Two Numbers

* [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

## Related Topics
* Linked List
* Recursion
* Math

## My Solution
中間小卡一部分，有看影片講解。但本題不一定要用 Recusive。

```java
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0); // new pre-header
    ListNode current = dummy; // new header, changes in while loop
    Integer carry = 0;

    while (l1 != null || l2 != null || carry != 0) {

        int value1 = 0;
        int value2 = 0;

        if (l1 != null) {
            value1 = l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            value2 = l2.val;
            l2 = l2.next;
        }

        // 相加大於 9
        int value = value1 + value2 + carry;
        carry = value / 10;
        value = value % 10;
        current.next = new ListNode(value);

        current = current.next;
    }

    return dummy.next;
}
```

## Well Solution
```java

```

## 參考
#### 影片
* https://www.youtube.com/watch?v=wgFPrzTjm7s
# 19 - Remove Nth Node From End of List

* [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## Related Topics
* Linked List
* Two Pointer

## My Solution
但沒有考慮到萬一移除的是 head 節點的情況。

```java
public static ListNode removeNthFromEnd(ListNode head, int n) {

    if (head.next == null) {
        return null;
    }

    int distance = 0; // 紀錄當前兩個節點的距離
    int pointer1 = 1, pointer2 = 1;
    ListNode node1 = head, node2 = head;

    while (node2.next != null) {
        distance = pointer2 - pointer1;
        
        if(distance < n) {
            node2 = node2.next;
            pointer2++;
            
        }else if(distance == n) {
            node1 = node1.next;
            node2 = node2.next;
            pointer1++;
            pointer2++;
        }
    }
    
    ListNode remove = node1.next;
    node1.next = remove.next;
    remove.next = null;
    
    return head; // 如果是 [2, 1], n = 1 這裡就會爆掉了
}
```

## Well Solution
```java
public static ListNode removeNthFromEnd(ListNode head, int n) {
		
    ListNode dummy = new ListNode(0); // 建一個 dummy 避免被移除的是 head
    ListNode left = dummy, right = dummy;
    left.next = head;
    
    for(int i = 1; i <= n + 1; i++) { // right 往右邊移動，每次移動 n 格，將第 n 個的節點記錄下來
        right = right.next;
    }
    
    while (right != null) { // left.next != null 代表還沒走到終點，所有指標一起右移
        left = left.next;
        right = right.next;
    }
    
    left.next = left.next.next; // 移除指定元素後將串鏈串到後面元素上
    return dummy.next;
}
```

## 參考
* https://www.youtube.com/watch?v=XVuQxVej6y8
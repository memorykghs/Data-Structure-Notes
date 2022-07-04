# 237 - Delete Node in a Linked List

* [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Related Topics
```java
public void deleteNode(ListNode node) {
    // 將下一個的值放到當前的node
    node.val = node.next.val;

    // 移除下一個節點
    node.next = node.next.next;
}
```
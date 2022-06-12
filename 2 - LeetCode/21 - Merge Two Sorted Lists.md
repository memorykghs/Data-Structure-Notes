# 21 - Merge Two Sorted Lists

* [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

## Related Topics
* Linked List
* Recursion

## My Solution
![](/images/LeetCode/21-1.png)

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode currentNode = dummy;

    while (list1.next != null || list2.next != null) { // 結束條件：兩個 list.next == null

        if (list1.val < list2.val) {
            currentNode.next = list1;
            currentNode = currentNode.next;
            list1 = list1.next;

        } else if (list2.val < list1.val) {
            currentNode.next = list2;
            currentNode = currentNode.next;
            list2 = list2.next;

        } else {
            currentNode.next = list1;
            currentNode.next.next = list2;
            currentNode = currentNode.next.next;
        }
    }
    
    return dummy.next;
}
```

![](/images/LeetCode/21-2.png)

## Well Solution
1. 沒有考慮到萬一其中一個 list 是 null，直接回傳另外一個 list 就好的狀況
2. Recursive 不一定要出現 `for` 或是 `while`，一直呼叫自己也可以
3. 呈上，這樣就不用特別多一個 ListNode 來記錄原本的 Head
4. 不需要考慮兩個 list 值相同的狀況，因為 `if else` 一次只會選擇一條路，等下一次的迭代處理就可以了

![](/images/LeetCode/21-3.png)

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    // 考慮到其中一個 list 為 null，直接回傳另外一個
    if (list1 == null) {
        return list2;
    }

    if (list2 == null) {
        return list1;
    }

    if (list1.val < list2.val) {
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    } else {
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
```

## 參考
* https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
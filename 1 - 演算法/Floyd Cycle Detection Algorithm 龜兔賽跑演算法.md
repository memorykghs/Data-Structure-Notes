# Floyd Cycle Detection Algorithm 龜兔賽跑演算法
* 主要是用來判斷 Linked List ( 鏈接串列 ) 中是否存在 cycle ( 環 ) 並找出環的起始點及算出 cycle 的長度

* 也可以用來找出 Linked List 位於中位數位置的 node

## 方法
1. 使用 Two Pointers：
  * `fast` - 代表兔子，每次移動 2 步
  * `slow` - 代表烏龜，每次移動 1 步

這兩個 pointers 的起點是同樣的。

2. 如果兩個 pointers 移動直到最終 ( `fast.next` = `null` ) 都沒有交集，代表此 Linked List 沒有 cycle。

3. 如果兩個 pointers 持續移動並在其中一個相遇 ( 不一定需要 )

![](/images/Algorithm/Floyd%20Cycle%20Detection%20Algorithm.gif)

## 範例
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
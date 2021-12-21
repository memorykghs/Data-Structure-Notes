# 06 - Hash Tables
Hash Table 是一種提供快速插入、刪除和查找鍵值對的數據結構。Hash Table 使用 **Linked List ( Dynamic Array )** 來有效的儲存建值對。插入鍵值對時，hash function 會先將鍵值 ( 通常是 String 或任何可以被 hash 的型別 ) 透過計算轉換成整數的 hash code，再映到射底層的動態陣列索引。

接著將與該鍵值關聯的值、以及與鍵值關聯的 reference 加到動態索引中。


Hash tables 依賴 hash code 來最小化儲存值時會發生的衝突 ( collisions )，也就是兩個鍵值映射到同一個索引的情況。 

下面是 Hahs Table 底層操作的示意：
```
[
  0: (value1, key1) -> null
  1: (value2, key2) -> (value3, key3) -> (value4, key4)
  2: (value5, key5) -> null
  3: (value6, key6) -> null
  4: null
  5: (value7, key7) -> (value8, key8)
  6: (value9, key9) -> null
]
```

在上面的 Hash Table 中，`key2`、`key3` 和 `key4` 擁有同樣的 hash code 1
；`key7` 和 `key8` 則是有同樣的 hash code 5。

![](/images/6-1.png)

下面是 Hahs Table 的標準操作與對應的時間複雜度：

* **Inserting a key/value pair**: O(1) on average; O(n) in the worse case
* **Removing a key/value pair**: O(1) on average; O(n) in the worse case
* **Looking up a key**: O(1) on average; O(n) in the worse case

最壞的情況，就是發生大量 hash code 相同時，導致內部存有很長的 Linked List，就需要 O(n) space time 來遍歷。

然而一般的情況下，我們會假裝 hash function 會套用某些數學最佳化的函式計算出 hash code，讓 hash code 極少發生重複，並保證操作值都維持 O(1)。

## 參考

## 延伸閱讀
* [淺談「Hash」、「Hashtable」與「HashMap」](https://medium.com/rick-x-coding/%E6%B7%BA%E8%AB%87-hash-hashtable-%E8%88%87-hashmap-4e5f5e5d36da)

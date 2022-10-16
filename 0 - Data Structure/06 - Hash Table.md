# 06 - Hash Table
## Hash 雜湊
Hash 比較偏向演算法的概念，而 Hashtable 跟 HashMap 則是與 Hash 相關的資料結構實作。

#### 特性
* 不可逆
* 唯一性 (期望)

常見的雜湊法有：
* MD5
* SHA-1
* SHA-2

#### 為何使用雜湊?
因為當數據資料再大，轉換後的雜湊長度是相等的，也只需要比對雜湊值，可以減少比對的成本。

#### 雜湊 vs. 加密
雜湊不等於加密，因為雜湊具有不可逆的特性。由於加密的最終目的是傳遞資料，所以在目的時需要還原這個資料原本的內容，只是在傳遞的過程中為了避免資料外洩時能夠不被讀懂。

但雜湊不需要還原資料，指示匯了讓這基資料在轉換後具有唯一性。

## Hash Table
Hash Table 是一種提供快速插入、刪除和查找鍵值對的數據結構。
* Hash Table 使用 **Linked List ( Dynamic Array )** 來有效的儲存建值對。
* 插入鍵值對時，hash function 會先將鍵值 ( 通常是 String 或任何可以被 hash 的型別 ) 透過計算轉換成整數的 hash code，再映到射底層的動態陣列索引。
* 接著將與該鍵值關聯的值、以及與鍵值關聯的 reference 加到動態索引中。

![](/images/DataStructure/6-2.png)

[圖片來源](https://rickbsr.medium.com/%E6%B7%BA%E8%AB%87-hash-hashtable-%E8%88%87-hashmap-4e5f5e5d36da)

## 專有名詞
* **桶(Bucket)** - 雜湊表中儲存資料的位置，每一個位置對應唯一位址(Bucket Address)。
* **槽(Slot)** - 每一個桶中的資料欄位，例如：一筆資料有 2 個欄位，則代表桶中有 2 
個槽。
* **碰撞(Collision)** - 若 2 筆資料經過雜湊函數運算後的雜湊值相同，也就是對應到相同位址時，稱為碰撞。
* **溢位(Overflow)** - 資料經過雜湊函數運算後，雜湊值所指向的桶位址已滿，無法再儲存，稱為溢位。

## Collisions
Hash tables 依賴 hash code 來最小化儲存值時會發生的衝突 ( collisions )，也就是兩個鍵值映射到同一個索引的情況。

首先可以根據是否移動到新的 bucket 分成兩種模式：
1. Closed Addressing
  (1) Separate Chaining 鏈結串鏈
  (2) Rehashing 再雜湊法???
2. Open Addressing
  依照 probing ( 探索 ) 的方式可以在分成幾種：
  (1) Linear Probing 線性探測
  (2) Quadratic Probing 平方探測
  (3) Double Probing

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

![](/images/DataStructure/6-1.png)

當遇到碰撞，且使用 chaining 的方式來解決時，當需要依照 `key` 取出 `value`，就會遍歷這個 Linked List 並使用 `equals()` 方法尋找。([參考](https://stackoverflow.com/questions/59224345/how-to-retrieve-values-after-a-hash-collision))


![](/images/DataStructure/6-3.png)
[圖片來源](https://4.bp.blogspot.com/-MJpDYFUhETI/VyTbS1HrsHI/AAAAAAAABA4/y3lqbDg0WUwouNFnDfGGr9-pJGxEF3wnACLcB/s1600/hashset-architecture.png)


## 操作成本
下面是 Hahs Table 的標準操作與對應的時間複雜度：

* **Inserting a key/value pair**: O(1) on average; O(n) in the worse case
* **Removing a key/value pair**: O(1) on average; O(n) in the worse case
* **Looking up a key**: O(1) on average; O(n) in the worse case

最壞的情況，就是發生大量 hash code 相同時，導致內部存有很長的 Linked List，就需要 O(n) space time 來遍歷。

然而一般的情況下，我們會假裝 hash function 會套用某些數學最佳化的函式計算出 hash code，讓 hash code 極少發生重複，並保證操作值都維持 O(1)。

但 Hashtable 現在官方建議以 ConcurrentHashMap 取代，原因是即使 Hashtable 的所有操作都是 thread-safe，但在資料檢索 ( retrieval operations ) 的時候並不會鎖定。類似料庫中只有 DML 會鎖定，但是 DQL 不會的概念。也就是雖然 thread-safe，但是 sychronized 並沒有覆蓋到所有的操作。詳情可以看 [ConcurrentHashMap 官方文件](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)。

## Map
在 Java 中的 Map，看底層結構應該是 bucket 採用 Tree 的格式來紀錄值，而不是 Linked List。推測可能是因為這樣可以叫快速的使用一些搜尋法找到指定的元素。

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

## 參考
* https://rickbsr.medium.com/%E6%B7%BA%E8%AB%87-hash-hashtable-%E8%88%87-hashmap-4e5f5e5d36da
* https://ithelp.ithome.com.tw/articles/10246777

## 延伸閱讀
* [淺談「Hash」、「Hashtable」與「HashMap」](https://medium.com/rick-x-coding/%E6%B7%BA%E8%AB%87-hash-hashtable-%E8%88%87-hashmap-4e5f5e5d36da)

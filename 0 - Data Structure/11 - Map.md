# 11 - Map

## Map 不屬於 Collection 架構
Collections 繼承架構。繼承「Collection」的介面有「Set」、「List」和「Queue」，但並沒有「Map」。
![](/images/DataStructure/11-1.png)

[圖片來源](https://commons.wikimedia.org/w/index.php?curid=64043967)

Map 繼承架構。
![](/images/DataStructure/11-2.png)

[圖片來源](https://commons.wikimedia.org/w/index.php?curid=64044187)

[What are the differets between a HashMap and a Hashtable in Java?](https://stackoverflow.com/questions/40471/what-are-the-differences-between-a-hashmap-and-a-hashtable-in-java?rq=1)

## put()
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
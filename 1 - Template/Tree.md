# Tree
## 核心
* 不存在 circle
* A Tree it is a connected graph with `N` nodes and `N-1` edges.

## Undirected Tree
![](/images/Template/tree-1.png)

* 以鄰接表 ( adjacncy list ) 呈現：
```
0 → [1]
1 → [0, 3, 4]
2 → [3]
3 → [1, 2, 6, 7]
4 → [1, 5, 8]
5 → [4]
6 → [3, 9]
7 → [3]
8 → [4]
9 → [6]
```

* 以 list 的方式呈現：
``` 
[(0, 1), 
 (1, 4),
 (4, 5),
 (4, 8),
 (1, 3),
 (3, 7),
 (3, 6),
 (2, 3),
 (6, 9)]
```
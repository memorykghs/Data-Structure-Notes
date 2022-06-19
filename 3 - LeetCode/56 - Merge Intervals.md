# 56 - Merge Intervals

* [Merge Intervals](https://leetcode.com/problems/merge-intervals/)

## Related Topics
* Array
* Sorting

## Well Solution
```java
public int[][] merge(int[][] intervals) {
    // 先排序
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    List<int[]> list = new ArrayList<>();
    int[] newInterval = intervals[0];
    
    list.add(newInterval);

    for (int[] interval : intervals) {
        if (interval[0] <= newInterval[1]) { // 如果迭代的 start 比現在的 interval 小，代表有重疊
            newInterval[1] = Math.max(newInterval[1], interval[1]); // 所以只要更新此 interval 的尾端

        } else { // 沒有重疊，是一個新的 interval
            newInterval = interval;
            list.add(newInterval);
        }
    }

    return list.toArray(new int[list.size()][]);
}
```

## 參考
* https://www.youtube.com/watch?v=44H3cEC2fFM
# 57 - Insert Interval

* [Insert Interva](https://leetcode.com/problems/insert-interval/)

## Related Topics
* Array

## My Solution
好像判斷太多次了。

```java
public int[][] insert(int[][] intervals, int[] newInterval) {

    List<int[]> list = new ArrayList<>();
    Arrays.sort(intervals, (s1, s2) -> Integer.compare(s1[0], s2[0]));

    int[] tempInterval = intervals[0];
    list.add(tempInterval);

    for (int[] interval : intervals) {
        if (interval[1] <= newInterval[0]) {
            tempInterval[1] = Math.max(newInterval[1], interval[1]);

        } else if (tempInterval[1] <= interval[0]) {
            tempInterval[1] = Math.max(tempInterval[1], interval[1]);

        } else {
            list.add(tempInterval);
            tempInterval = interval;
        }
    }
    
    return list.toArray(new int[list.size()][]);
}
```

## Well Solution
```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>();

    int i = 0;

    // add all the intervals ending before newInterval starts
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        list.add(intervals[i++]);
    }

    // merge all overlapping intervals to one considering newInterval
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        // we could mutate newInterval here also
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }

    // add the union of intervals we got
    list.add(newInterval);

    // add all the rest
    while (i < intervals.length) {
        list.add(intervals[i++]);
    }

    return list.toArray(new int[list.size()][]);
}
```

## 參考
* https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
# 88 - Merge Sorted Array

* [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

## Related Topics
* Array
* Two Pointers
* Sorting

## My Solution
```java

```

## Well Solution
###### Hint 1
> You can easily solve this problem if you simply think about two elements at a time rather than two arrays. We know that each of the individual arrays is sorted. What we don't know is how they will intertwine. Can we take a local decision and arrive at an optimal solution?

###### Hint 2
> If you simply consider one element each at a time from the two arrays and make a decision and proceed accordingly, you will arrive at the optimal solution.

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail1 = m - 1;
    int tail2 = n - 1;
    int finish = m + n - 1;
    
    while(tail1 >= 0 && tail2 >= 0) {
        nums1[finish--] = ( nums1[tail1] > nums2[tail2] ) ? nums1[tail1--] : nums2[tail2--];
    }
    
    while (tail2 >= 0) {
        nums1[finish--] = nums2[tail2--];
    }
}
```

## 參考
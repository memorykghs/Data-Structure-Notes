# 300 - Longest Increasing Subsequenc

* [Longest Increasing Subsequenc]()

## Related Topics


## My Solution
```java
public static int lengthOfLIS(int[] nums) {
    int length = nums.length;
    int start = 0;
    int end = 1;
    int count = 0;

    int diffSum = 0;
    while (start < end && end < length) {

        int diff = nums[end] - nums[end - 1];
        int tempDiffSum = diffSum + diff;

        if (tempDiffSum >= diffSum) { // increase, move end
            count++;

        } else {
            if (diff < 0) { // decrease, move start
                start++;
                diffSum = Math.min(diffSum, tempDiffSum);
                
            }
        }
        
        end++;
    }
    return count;
}
```

## Well Solution
```java

```

## 參考
* https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
↑ 有人放了一個 PDF 耶
# 01 - Two Sum

* [Two Sum](https://leetcode.com/problems/two-sum/)

## Related Topics
* Array
* Hash Table

## My Solution
一開始想到用兩個迴圈，但這樣是 O(n<sup>2</sup>)，略冗。
```java
public int[] twoSum(int[] nums, int target) {
    for(int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            
            int sum = nums[i] + nums[j];
            
            if(sum < target || sum < target) {
                continue;
            } else if(sum == target) {
                return new int[] {i, j};
            }
        }
    }
    
    return new int[] {0, 0};
}
```

## Well Solution
使用 Map 做出 `(key = nums[i], value = i)` 的結構。

![](/images/LeetCode/1-2.png)

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

        int substract = target - nums[i];
        if (map.containsKey(substract) && map.get(substract) != i) {
            return new int[] { map.get(substract), i };
        }

        map.put(nums[i], i);
    }

    return new int[] { 0, 0 };
}
```

## 參考
#### 影片
* https://www.youtube.com/watch?v=KLlXCFG5TnA
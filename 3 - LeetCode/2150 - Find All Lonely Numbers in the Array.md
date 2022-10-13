# 2150 - Find All Lonely Numbers in the Array

* [Find All Lonely Numbers in the Array](https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/)

## Related Topics
* Array
* Hash Table
* Counting

## My Solution
一開始想到的就是用 Map 然後內容大概長的像下面這樣，用 `key` 當作是出現的數字，`value` 當作是出現的次數，但是就是會跑兩個迴圈 ( 雖然還是 O(n) 啦 )。

```
(key = nums[i], value = appear times of nums[i])
```

```java
public static void main(String[] args) {
    loneyNumber(new int[] { 10, 5, 6, 3 });
    loneyNumber(new int[] { 1, 3, 5, 3 });
}

/*
 * LeetCode 2150 - Find All Lonely Numbers in the Array
 */
public static List<Integer> loneyNumber(int[] nums) {

    /*
     * 1. no adjacent 
     * 2. no duplicate
     */

    List<Integer> result = new ArrayList<>();

    // corner case
    if (nums.length == 1) {
        result.add(nums[0]);
        return result;
    }

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    for (int key : map.keySet()) {
        if (map.containsKey(key + 1) || map.containsKey(key - 1) || map.get(key) > 1) {
            continue;
        } else {
            result.add(key);
        }
    }
    return result;
}
```

優化了 Map API 的用法。
```java
public static void main(String[] args) {
    loneyNumber(new int[] { 10, 5, 6, 3 });
    loneyNumber(new int[] { 1, 3, 5, 3 });
}

/*
 * LeetCode 2150 - Find All Lonely Numbers in the Array
 */
public static List<Integer> loneyNumber(int[] nums) {

    /*
     * 1. no adjacent 
     * 2. no duplicate
     */
    
    List<Integer> result = new ArrayList<>();
    
    // corner case
    if(nums.length == 1) {
        result.add(nums[0]);
        return result;
    }

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // uses map.getOrDefault API
    }
    
    for(int key : map.keySet()) {
        if(!map.containsKey(key + 1) && !map.containsKey(key - 1) && map.get(key) == 1) {
            result.add(key);
        }
    }
    return result;
}
```

不過效能一樣爛，要在想看看有沒有其他方法可以讓效能快一點。
![](/images/LeetCode/2150-1.png)

## Well Solution
```java

```

## 參考

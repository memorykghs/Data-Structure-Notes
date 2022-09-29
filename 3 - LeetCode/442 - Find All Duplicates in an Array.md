# 442 - Find All Duplicates in an Array

* [Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

## Related Topics
* Array
* Hash Table

## My Solution
因為限制條件有這些：
* `1 <= nums[i] <= n`
* `Each element in nums appears once or twice.`
* 要求時間複雜度為 O(n)，空間複雜度為 O(1)

所以下面這個多用了 Hash Set 的方式其實是違法的QQ。

```java
public List<Integer> findDuplicates(int[] nums) {
		
    List<Integer> result = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    
    if(nums.length == 1) {
        return result;
    }
    
    for(int num : nums){
        if(!set.add(num)) {
            result.add(num);
        }
    }
    
    return result;
}
```

## Well Solution
詳細解法可以看這篇：https://blog.csdn.net/fuxuemingzhu/article/details/79275549。

看完會恍然大悟，有點像是用映射的方式在對應到的地方做記號。

```java
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new LinkedList<>();
    
    // 取反
    for(int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;
        if(nums[index] < 0) { // 表示已經走過了
            result.add(index + 1);
        }
        nums[index] = -nums[index];
    }
    
    return result;
    }
```

## 參考
* https://blog.csdn.net/fuxuemingzhu/article/details/79275549


# 217 - Contains Duplicate

* [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

## Related Topics
* Array
* Hash Table
* Sorting

## My Solution
想到兩種解法：Hash Set 和快慢指針。

###### Method 1 快慢指針
有夠醜。有時候還是不要想得太複雜。
```java
public boolean containsDuplicate(int[] nums) {		
    // Method 1
    if(nums.length < 2) {
        return false;
    }

    int slow = 0;
    int fast = nums[nums[0]];

    while (slow != fast) {
        
        if (nums[slow] == nums[fast]) {
            return true;
            
        } else if (nums[slow] != nums[fast] || fast >= nums.length - 1){
            fast = fast + 2 >= nums.length - 1 ? 0 : fast + 2;
            slow++;
        }
    }
    return false;
}
```

###### Method 2 Hash Set
```java
public boolean containsDuplicate(int[] nums) {		
    // Method 2
    Set<Integer> set = new HashSet<>();
    for(int num : nums) {
        if(set.isEmpty() || !set.contains(num)) {
            set.add(num);
        } else if(set.contains(num)) {
            return true;
        }
    }
    return false;
}
```

## Well Solution
Hash Set 變化型，那個時間之差屌打原本的寫法...。
```java
public boolean containsDuplicate(int[] nums) {		
    for(int num : nums) {
        if(!set.add(num)) {
            return true;
        }
    }
    return false;
}
```

## 參考
* https://harry811016.medium.com/%E5%88%B7%E9%A1%8C%E5%B8%B8%E7%94%A8%E6%8A%80%E5%B7%A7-%E4%BA%8C-%E9%9B%99%E6%8C%87%E9%87%9D%E6%96%B9%E6%B3%95-8d8261054f8c

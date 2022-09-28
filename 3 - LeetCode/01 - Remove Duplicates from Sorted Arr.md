# 01 - Remove Duplicates from Sorted Array

* [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Related Topics
* Array
* Two Pointers

## My Solution
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int counter = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != nums[counter]){
                counter++;
                nums[counter] = nums[j];
            }
        }
        
        return counter + 1;
    }
}
```

## Well Solution
```java
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
}
```

![](/images/LeetCode/1-1.png)
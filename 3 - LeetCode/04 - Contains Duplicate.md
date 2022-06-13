# 04 - Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

#### Example
```
Input: nums = [1,2,3,1]
Output: true
```

```
Input: nums = [1,2,3,4]
Output: false
```

#### Constraints:
* `1 <= nums.length <= 105`
* `-109 <= nums[i] <= 109`

#### My Solution
方案一：會 time out
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
```

方案二：先排序在兩兩比較
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
```
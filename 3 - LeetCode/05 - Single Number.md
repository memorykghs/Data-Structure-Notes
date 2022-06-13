# 05 - Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

#### Example
```
Input: nums = [2,2,1]
Output: 1
```

```
Input: nums = [4,1,2,1,2]
Output: 4
```

```
Input: nums = [1]
Output: 1
```

#### Constraints:
* `1 <= nums.length <= 3 * 104`
* `-3 * 104 <= nums[i] <= 3 * 104`
* Each element in the array appears twice except for one element which appears only once.

#### My Solution
上面的限制**每個數字都只會出現兩次，除了不重複的那個只會出現一次**很重要，有這個前提才不用去判斷出現幾次。
```java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums); // 排序
        int temp = 0;
        
        for(int i = 0; i < nums.length; i += 2){
            if(nums.length == 1){
                temp = nums[i];
                break;
            }
            
            if(i == nums.length - 1 && nums[i] != nums[i - 1]){
                temp = nums[i];
                break;
            }
            
            if(nums[i] != nums[i+1]){
                temp = nums[i];
                break;
            }
        }
        
        return temp;
    }
}
```

#### Well Solution
方法一：利用 Set 的特性，遇到重複的就刪除 Set 內的物件，不重複就加到 Set 內
```java
class Solution {
    public int singleNumber(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        
        return (int) set.iterator().next();
    }
}
```
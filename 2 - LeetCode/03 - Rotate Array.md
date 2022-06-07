# 03 - Rotate Array
Given an array, rotate the array to the right by k steps, where k is non-negative.

#### Example
```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

#### Constraints:
* `1 <= nums.length <= 105`
* `-231 <= nums[i] <= 231 - 1`
* `0 <= k <= 105`

#### Follow up:
* Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
* Could you do it in-place with O(1) extra space?

#### My Solution
```java
// none
```

#### Well Solution
```java
class Solution {
    public void rotate(int[] nums, int k) {
        
        k %= nums.length; // 看是否輪轉為原本的順序
        
        if(k != 0){
            reverse(nums, 0, nums.length -1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length -1);
        }
    }
    
    private void reverse(int[] nums, int start, int end){
        
        int temp;
        
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

![](/images/LeetCode/3-1.png)
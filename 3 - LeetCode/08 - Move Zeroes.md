# 08 - Move Zeroes
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note** that you must do this in-place without making a copy of the array.

#### Example
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

```
Input: nums = [0]
Output: [0]
```

#### Constraints:
* `1 <= nums.length <= 104`
* `-231 <= nums[i] <= 231 - 1`

Follow up: Could you minimize the total number of operations done?

#### Hints
A **`two-pointer`** approach could be helpful here. The idea would be to have one pointer for iterating the array and another pointer that just works on the non-zero elements of the array.

#### My Solution
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int end = nums.length - 1;
		int start = 0;
		int temp = 0;
		
		while (start < end) {
			if(nums[start] == 0) {
				temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}
    }
}
```

嗯...Timeout Q_Q
總覺得離答案很近，而且其實根本不用照大小排序......
![](/images/LeetCode/8-1.jpg)

#### Well Solution
```java
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
```

or

```java
class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length == 0){
           return; 
        }
        
        int count = 0;
        for(int num : nums){
            if(num != 0){
                nums[count] = num;
                count++;
            }
        }
        
        while(count < nums.length){
            nums[count] = 0;
            count++;
        }
    }
}
```
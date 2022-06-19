# 55 - Jump Game

* [Jump Game](https://leetcode.com/problems/jump-game/)

## Related Topics
* Array
* Dynamic Programming
* Greedy

## My Solution
![](/images/LeetCode/55-1.png)

```java
public boolean canJump(int[] nums) {
        
    if(nums.length == 1) {
        return true;
    }

    int i = 0;
    while (i < nums.length) {

        // 遇到 0 就回傳 false
        if (nums[i] == 0 && i != nums.length - 1) {
            return false;
        }
        
        i = nums[i] == 0 ? i++: i + nums[i];
    }
    return true;
    }
```

## Well Solution
![](/images/LeetCode/55-2.png)

```java
public static boolean canJump(int[] nums) {

    int goal = nums.length - 1; // 當前要達到的目標值

    for (int i = nums.length - 1; i >= 0; i--) {

        // 遇到 0 就回傳 false
        if (i + nums[i] >= goal) { // 如果當前的所在的 index + 目前該 step 的步數 >= goal，表示可到達
            goal = i;
        }
    }

    return goal == 0;
}
```

## 參考
* https://www.youtube.com/watch?v=Yan0cv2cLy8
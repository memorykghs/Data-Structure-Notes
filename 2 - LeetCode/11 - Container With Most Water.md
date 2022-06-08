# 11 - Container With Most Water

* [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

## Related Topics
* Array
* Two Pointers
* Greedy

## My Solution
```java
public static int maxArea(int[] height) {

    int container = 0; // 紀錄容量

    for (int i = 0; i < height.length; i++) {
        for (int j = i + 1; j < height.length; j++) {

            int num = Math.min(height[i], height[j]);
            int length = j - i;
            container = Math.max(container, num * length);
        }
    }

    return container;
}
```

果然超出時間ㄌ...應該要找方法去掉不必算的數字。

![](/images/LeetCode/11-1.png)

![](/images/LeetCode/11-2.png)

## Well Solution

![](/images/LeetCode/11-3.png)

```java
public static int maxArea(int[] height) {

    int container = 0; // 紀錄容量

    int i = 0;
    int j = height.length - 1;

    while (i < j) {

        int num = Math.min(height[i], height[j]);
        int length = j - i;
        container = Math.max(container, num * length);

        if (height[i] < height[j]) {
            i++;
        } else if (height[i] > height[j]) {
            j--;
        } else {
            i++;
        }
    }

    return container;
}
```

## 參考
* https://www.youtube.com/watch?v=UuiTKBwPgAo
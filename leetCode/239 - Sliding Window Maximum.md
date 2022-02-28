# 239 - Sliding Window Maximum

https://leetcode.com/problems/sliding-window-maximum/

原解法：
原本使用 LinkedList 來控制在 window 內的元素，且用一個 temp 參數紀錄目前的最大值。

結果：Time out

```java
public static int[] maxSlidingWindow(int[] nums, int k) {

    // 判斷 k
    if (k == 1) {
        return nums;
    }

    // 獲得後續的 stream
    List<Integer> list = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    Arrays.stream(nums).forEach(s -> {

        list.add(s);

        // 加入 List 的量與 w 相同時進行判斷
        if (list.size() == k) {
            int temp = list.get(0);

            for (int i = 0; i < k; i++) {
                int s1 = list.get(i);
                if (temp < s1) {
                    temp = s1;
                }

                if (i == k - 1) {
                    result.add(temp);
                    System.out.println(temp + " ");
                }
            }
            list.remove(0);
        }
    });

    int[] resultArr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
        resultArr[i] = result.get(i);
    }

    return resultArr;
}
```

## 概念
主要是考 Array 以及 Queue 的概念。在這裡使用 Dequeue ( Double-ended Queue ) 效率上較 List 或是 Array 快。
1. Dequeue 中的每一個元素都可在佇列的左邊或是右邊逕行任何元素的新增移除
2. Deque 繼承自 Queue
    ```
    java.util.Queue
          △
          |
          |
          |
    java.util.Deque
    ```
3. 運行速度較 Stack 和 List 快
4. 可以被不同類別的集合實作，如 LinkedList、ArrayDeque
  ```java
  Deque deque = new LinkedList<>();
  Deque deque = new ArrayDeque<>();
  ```

## 解法
```java
public static int[] maxSlidingWindow2(int[] nums, int k) {
		// 判斷 k
		if (k == 1) {
			return nums;
		}

		int times = nums.length - k + 1;
		int[] result = new int[times];
		Deque<Integer> dq = new LinkedList<>(); // 存 window 內看的到的數字

		int ri = 0;
		for (int i = 0; i < nums.length; i++) { // loop index

			// 確保 dq 內存的是當前 window 中應該要看到的 index
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}
			
			// 加入的最後一個比當前的還要小，就拉最後一個
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}

			dq.offer(i); // 將 index 加入 dq
			
			// 當現在的 index 大於 k (代表 k-1 之前都不放)
			if(i >= k - 1) {
				result[ri] = nums[dq.peek()]; // 因為小的已經在前面的步驟被刪除了，所以直接拿第一個
				ri++;
			}
		}
		return result;
	}

```

可以分成幾個步驟：
1. 首先，視窗大小 k 與陣列長度 nums.length，最多最多需要輪 `nums.length - k + 1` 次
2. 建立一個 Deque 物件，讓這個物件紀錄並更新當前應該要看到的元素的 index

## 參考
* https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
* https://www.cnblogs.com/grandyang/p/4656517.html
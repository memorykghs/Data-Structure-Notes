# 46 - Permutations

* [Permutations](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/)

## Related Topics
* Backtracking

## My Solution
```java
package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3 };
		System.out.print(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> returnList = new ArrayList<>();
		recursion(returnList, nums, 0);

		return returnList;
	}

	private static void recursion(List<List<Integer>> returnList, int[] nums, int level) {

		for (int i = 0; i < nums.length; i++) { // 以第幾個元素為開頭

			List<Integer> list = new ArrayList<>();
			list.add(nums[i]);
			int[] temp = nums;

			// 將當前數字換到開頭
			change(temp, 0);

			for (int j = 0; j < temp.length; j++) { // 換到第幾個元素

				if (list.size() == nums.length) {
					list.add(temp[j]);
				}

				// 呼叫遞迴
			}
		}
	}

	/*
	 * 交換順序
	 */
	private static void change(int[] temp, int originInx, int newInx) {
		int tempNum = temp[originInx];
		temp[originInx] = temp[newInx];
		temp[newInx] = tempNum;
	}
}
```

## Well Solution
#### 方法一
有點難以言喻，直接 debug 模式比較好理解。

```java
class Solution {
   public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> returnList = new ArrayList<>();

		if (nums.length == 0) {
			return returnList;
		}

		recursion1(returnList, new ArrayList<>(), nums);
		return returnList;
	}

	private static void recursion1(List<List<Integer>> returnList, List<Integer> tempList, int[] nums) {

		if (tempList.size() == nums.length) {
			returnList.add(new ArrayList<>(tempList));

		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i])) { // 元素已經存在
					continue;

				} else {
					tempList.add(nums[i]);
					recursion1(returnList, tempList, nums);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
}
```

#### 方法二
利用遞迴的方式一層一層往下遍歷。另外 `list.add(index, value)` 當在某個指定位置插入一個值，那麼原本這個位置的值以及其後面的值，都會往後移，而不是將這個位置的值覆蓋掉。

```java
class Solution {
   public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> returnList = new ArrayList<>();

		if (nums.length == 0) {
			return returnList;
		}

		recursion(returnList, new ArrayList<>(), nums, 0);
		return returnList;
	}

	private static void recursion(List<List<Integer>> returnList, List<Integer> tempList, int[] nums, int index) {
		
		if(tempList.size() == nums.length) { // 當 list 已經湊滿三個
			returnList.add(tempList);
			return;
		}

		for (int i = 0; i <= tempList.size(); i++) { // 遍歷 nums 的第幾個元素
			
			List<Integer> list = new ArrayList<>(tempList);
			list.add(i, nums[index]);

			recursion(returnList, list, nums, index + 1);
        }
	}
}
```

## 參考
* https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
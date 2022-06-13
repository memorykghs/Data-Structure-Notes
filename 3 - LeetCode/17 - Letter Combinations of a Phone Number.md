# 17 - Letter Combinations of a Phone Number
* [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## 原本解法
沒寫出來QQ
```java
package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {
	public static void main(String[] args) {
		List<String> resultList = letterCombinations("234");
		
		resultList.stream().forEach(x -> System.out.println(x));
	}

	public static List<String> letterCombinations(String digits) {

//		Map<Integer, String> map = new HashMap<>();
//		map.put(2, "abc");
//		map.put(3, "def");s
//		map.put(4, "ghi");
//		map.put(5, "jkl");
//		map.put(6, "mno");
//		map.put(7, "pqrs");
//		map.put(8, "tuv");
//		map.put(9, "wxyz");

		String[] defaultArr = new String[] { null, "abc", "def", "ghi", "mno", "pqrs", "tuv", "wxyz" };

		if (digits.length() > 4) {
			return new ArrayList<>();
		}

		List<String> resultList = new ArrayList<>(); // 結果

		int length = digits.length();
		String[] digitsArr = digits.split("");

		// 將目前的值都放到 array 裡
		String[] alphebateArr = {};
		for (int i = 0; i < digitsArr.length; i++) {
			alphebateArr[i] = defaultArr[Integer.parseInt(digitsArr[i])];
		}

		int k = length;
		while (k > 0) {
			String result = "";
			recursive(k, result, length, alphebateArr, resultList);
			
		}

		return resultList;
	}
	
	private static void recursive(int k, String str, int length, String[] alphebateArr, List<String> resultList) {
		String[] arr = alphebateArr[length - k].split("");

		for (int x = 0; x < arr.length; x++) {
			str += arr[x];

			if (k == 1) {
				str += arr[x];
				resultList.add(str);
			} else {
				str += arr[x];
				recursive(k, str, length, alphebateArr, resultList);
			}
		}
		k--;
	}
}
```

## 參考解法
利用遞迴。
```java
package leetCode.medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {

	public static String[] MAPPING = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		List<String> resultList = letterCombinations("234");

		resultList.stream().forEach(x -> System.out.println(x));
	}

	public static List<String> letterCombinations(String digits) {

		List<String> resultList = new LinkedList<>();

		if (digits.isEmpty()) {
			return resultList;
		}

		recursive("", digits, 0, resultList); // 初始字串, digits, k(第幾層), resultList
		return resultList;
	}

	private static void recursive(String str, String digits, int k, List<String> resultList) {
		if (k >= digits.length()) { // 到最大層數就把結果放進 list
			resultList.add(str);
			return;
		}

		String letters = MAPPING[digits.charAt(k) - '0']; // 為了將拿到的 digits 轉成數字
		for(int i = 0; i < letters.length(); i++) { // 串接字母
			// 呼叫遞迴
            recursive(str + letters.charAt(i), digits, k + 1, resultList);
		}
	}
}
```
* 字母相減用意：https://blog.csdn.net/xiaozhouchou/article/details/54350113

## 概念
* Backtracking：https://haogroot.com/2020/09/21/backtracking-leetcode/
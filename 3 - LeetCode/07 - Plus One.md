# 07 - Plus One
You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the `i`th digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s.

Increment the large integer by one and return the resulting array of digits.

#### Example
```
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```

```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
```

```
Input: digits = [0]
Output: [1]
Explanation: The array represents the integer 0.
Incrementing by one gives 0 + 1 = 1.
Thus, the result should be [1].
```

```
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
```

#### Constraints:
* `1 <= digits.length <= 100`
* `0 <= digits[i] <= 9`
* `digits` does not contain any leading `0`'s.

#### My Solution
```java
class Solution {
    public int[] plusOne(int[] digits) {
       if (digits.length < 1 || digits.length > 100) {
			return digits;
		}

		// String numStr = Arrays.asList(digits).stream().map(x ->
		// String.valueOf(x)).reduce((x, y) -> x.concat(y)).get();
		String numStr = "";
		for (int i = 0; i < digits.length; i++) {
			numStr += digits[i];
		}

		int num = Integer.parseInt(numStr) + 1;
		String[] strArr = String.valueOf(num).split("");

		int[] result = new int[strArr.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}

		return result;
    }
}
```

"`large Integer`" &rArr; 所以會爆...Integer 有最大上限，只能一個一個位數算。
總覺得，今天寫得很阿砸 il||li(つд-｡)il||li......

#### Well Solution
```java
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}
```

![](/images/LeetCode/7-1.png)

#### 補充
* [two pointer arrange](https://blog.techbridge.cc/2019/08/30/leetcode-pattern-two-pointer/) 

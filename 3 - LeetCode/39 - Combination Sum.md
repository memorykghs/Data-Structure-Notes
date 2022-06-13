# 39 - Combination Sum

* [Combination Sum](https://leetcode.com/problems/combination-sum/)

## Related Topics
* Array
* BackTracking

## My Solution
#### 題目限制
1. 每個 target 保證由少於 150 個數字的和組成
2. 數字使用次數不限

#### 解題思維
1. 先排序，遇到太大的或是前面用過的就可以跳過
2. 除果出現兩個一樣的數字，須排除重複的
3. 記得回復到上一個狀態

![](/images/LeetCode/39-1.png)

根本就是錯在放錯 index ( 把 `j` 放成 `i`，難怪都不會往下一圈走= = )。
```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new LinkedList<>();

    backtrack(0, 0, new LinkedList<>(), candidates, target, list);
    return list;
}

private void backtrack(int i, int sum, List<Integer> subList, int[] candidates, int target,
        List<List<Integer>> list) {
    if (sum > target) { // 如果數字超過就停止
        return;
    }

    if (sum == target) {
        list.add(new LinkedList<>(subList)); // 避免因物件參考記憶體位址導致值被改變
    }

    for (int j = i; j < candidates.length; j++) {

        sum = sum + candidates[j];

        // 如果後一個數字跟前一個一樣，跳過
        if (j > i && candidates[j] == candidates[j - 1]) {
            continue;
        }

        // 數字大於 target
        if (candidates[j] > target) {
            return;
        }

        if (sum > target) {
            return;
        }

        subList.add(candidates[j]);
        System.out.print(candidates[j]);
        backtrack(j, sum, subList, candidates, target, list);

        // 回到上一個狀態，backtracking
        sum = sum - candidates[j];
        subList.remove(subList.size() - 1);
    }
}
```

## 參考
* https://www.youtube.com/watch?v=GBKI9VSKdGg
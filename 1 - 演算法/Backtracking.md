# Backtracking 回溯法
Backtacking 是一種 DFS ( Depth-First Search，深度優先搜尋 ) 的形式，類似於 Top-down DFS 但是加入了狀態回溯。可以把他想像成窮舉法，將所有可能的路徑都窮舉出來，每一個選擇的路徑都要走過。

在使用回溯法的技巧時，有三個

1. 紀錄當前的狀態 ( 或選擇的值 )
2. 選擇清單：當下可以選擇的路徑，做完之後會從選擇清單中移除，然後更新當前狀態
3. 終止條件：達到決策數的終點，代表此分支已經被走完

![](/images/Template/backtracking-1.png)

![](/images/Template/backtracking-2.png)

比較常用到的會是用遞迴的方式。

#### 模板
1. Base Case
2. 對每一個可選擇的狀態進行遍歷
    (1) 紀錄當前狀態
    (2) 呼叫遞迴 recusive()，並在內部設定終止條件
    (3) 更新當前狀態

## 剪枝技巧 ( prune )
當條件中下一步可選的狀態，可能依照 index 的前後 ( 下一個值的 index 不能小於前一個，需要按照順序 )，就適合使用。可以同時他配 Bottom-up 的搜尋方式較為簡單。

#### 模板一

適用範例：[1641 - Count Sorted Vowel Strings]()

## Leetcode 範例
* [17 - Letter Combinations of a Phone Number]()
* [39 - Combination Sum](https://leetcode.com/problems/combination-sum/)
* [46. Permutations](https://leetcode.com/problems/permutations/)
* [77. Combinations](https://leetcode.com/problems/combinations/)
* [78. Subsets](https://leetcode.com/problems/subsets/)


## 參考
* https://haogroot.com/2020/09/21/backtracking-leetcode/

#### 影片
* https://www.youtube.com/watch?v=xqidNhvwKzI
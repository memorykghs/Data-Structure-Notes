# 03 - Big O Notation
Big O 是幫助我們描述某個操作花費的成本，包括：
* **時間複雜度 Time Complexity**
主要用來衡量演算法的速度。
<br/>

* **空間複雜度 Space Complexity**
衡量演算法占用多少輔助內存。

Big O notation 使用傳入的變量表示大小，例如：**O(n)** 可以是便利一個長度為 **n** 的陣列所需的時間複雜度；**O(n + m)** 也有可能是變歷某個長度為 **n**、集合內的每個個字串的長度為 **m** 的陣列。

以下是常見的 Big O notation，由最快到最慢的順序為： 

* **Constant**：O(1)<br/>
* **Logarithmic**：O(log(n))<br/>
* **Linear**：O(n)<br/>
* **Log-linear**：O(nlog(n))<br/>
* **Quadratic**：O(n<sup>2</sup>)<br/>
* **Cubic**：O(n<sup>3</sup>)<br/>
* **Exponential**：O(2<sup>n</sup>)<br/>
* **Factorial**：O(n!)<br/>

![](/images/3-1.png)

[圖片來源](http://alrightchiu.github.io/SecondRound/complexityasymptotic-notationjian-jin-fu-hao.html)
<br/>

## 為何是 O(1)? 1 代表什麼意思?


## 重點整理
* Big O notation 通常是用來描述 **最壞 ( worst-case )** 狀況下所需的成本。
 


For example, some sorting algorithms have different time complexities
depending on the layout of elements in their input array. In rare cases, their
time complexity will be much worse than in more common cases. Similarly, an
algorithm that takes in a string and performs special operations on uppercase
characters might have a different time complexity when run on an input string
of only uppercase characters vs. on an input string with just a few uppercase
characters.


Thus, when describing the time complexity of an algorithm, it can sometimes be
helpful to specify whether the time complexity refers to the average case or
to the worst case (e.g., "this algorithm runs in O(nlog(n)) time on average
and in O(n<sup>2</sup>) time in the worse case").

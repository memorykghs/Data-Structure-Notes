# 08 - String
雖然 String 本身不是獨立的數據結構，但他通常被認為是一種行為類似於數據結構的數據類型。String 的每個字元會透過某種字符編碼標準 ( 如 ASCII Code ) 轉換成整數儲存在 array 中。

String 的操作行為很像 array，主要的區別在於，大多數的程式語言中 ( C++ 是個例外 ) 中，String 是**不可變的 ( immutable )**。這代表他們被創造後就無法進行編輯，像是String 的串接，他所花費的成本會比想像中的多。

下面是一個範例：
```
string = "this is a string"
newString = ""

for character in string:
    newString += character
```

上述的 time complexity 為 **O(n<sup>2</sup>)**，其中 `n` 是 String 的長度，因為每增加一個字元，需要先將原本的字串複製、紀錄在新的記憶體位置後再將新字元寫入。複製 String 內的所有字元本身就是一個 **O(n)** 操作，然後將這些字元寫入新的記憶體位置是另一個 **O(n)** 操作，整體的成本是 **O(n<sup>2</sup>)**。

String 的標準操作與對應的時間複雜度：
* traverse：**O(n)** time complexity、**O(1)** space complexity ( 假設單純的遍歷而不做其他操作 )
* copy N character：**O(n)** space time complexity
* get character from index：**O(1)** space time complexity ( 因為字串也是以一種 array 的形式被儲存 )
* 與 array 不同，沒有 set character 至指定 index 的操作

所以當遇到需要串接多個字串或是替換掉字串中的某個字元時，通常會建議先將字串 `split()` 變成 array 後在使用其方法進行操作，因為 array 的 set 與 get 都是 O(n)，copy 也是 O(n)。

## LeetCode

#### Easy
* [Reverse Integer](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880)

* [Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

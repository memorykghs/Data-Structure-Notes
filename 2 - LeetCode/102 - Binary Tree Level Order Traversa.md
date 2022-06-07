# 102 - Binary Tree Level Order Traversal

* [Binary Tree Level Order Traversal](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/)

## Related Topics
* Binary Tree
* Queue

## Well Solution
![](/images/LeetCode/102-1.png)

```java
public List<List<Integer>> levelOrder(TreeNode root) {
        
    Queue<TreeNode> queue = new LinkedList<>(); // 紀錄遇到的 Node
    List<List<Integer>> returnList = new LinkedList<>();
    
    if(root == null){
        return returnList;
    }
    
    // 將 root 放入 queue
    queue.offer(root);
    
    while(!queue.isEmpty()){
        int levelNum = queue.size(); // 紀錄這一層有幾個 node
        List<Integer> subList = new LinkedList<>(); // 放值的 List
        
        for(int i = 0; i < levelNum; i++){
            
            if(queue.peek().left != null){ // 判斷 left child node 是否有值
                queue.offer(queue.peek().left);
            }
            
            if(queue.peek().right != null){ // 判斷 right child node 是否有值
                queue.offer(queue.peek().right);
            }
            
            subList.add(queue.poll().val); // 把當前的值加入 subList 內，並從 queue 中移除
        }
        
        returnList.add(subList);
    }
    
    return returnList;
}
```
---
title: "Find its maximum depth."
tags: Leetcode, BinaryTree, Easy
---

### Question
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Links
* [Question link](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
* [Code](./MaxDepthOfTree.java)
* [Discussion](https://discuss.leetcode.com/category/112/maximum-depth-of-binary-tree)

### Notes


### Code
```java
public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
```
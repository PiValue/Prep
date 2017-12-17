package com.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TreeNode {
    private int val;
    private TreeNode left, right;
}

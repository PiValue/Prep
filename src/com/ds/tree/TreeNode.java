package com.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TreeNode {
    public int val;
    public TreeNode left, right;
}

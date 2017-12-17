package com.ds.lists;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DListNode {
    public int val;
    public DListNode next, prev;
}

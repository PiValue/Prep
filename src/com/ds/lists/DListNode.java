package com.ds.lists;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DListNode {
    private int val;
    private DListNode next, prev;
}

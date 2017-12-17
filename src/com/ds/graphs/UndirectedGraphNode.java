package com.ds.graphs;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UndirectedGraphNode {
    private int label;
    private List<UndirectedGraphNode> neighbors;

    /**
     * Constructor.
     * @param x
     */
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

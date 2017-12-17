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
     * @param label
     */
    public UndirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

package com.ben.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/9/2.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

package com.ben.leetcode;

import com.ben.leetcode.common.UndirectedGraphNode;
import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/9/1.
 */
public class Q133_M_Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Map<Integer, UndirectedGraphNode> map = new HashMap<>();

        return helper(node, map);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);

        if (node.neighbors != null && node.neighbors.size() > 0) {
            copy.neighbors = new ArrayList<>(node.neighbors.size());

            for (UndirectedGraphNode n : node.neighbors) {
                UndirectedGraphNode temp = map.get(n.label);
                if (temp == null) {
                    temp = helper(n, map);
                }
                copy.neighbors.add(temp);
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        Q133_M_Clone_Graph q = new Q133_M_Clone_Graph();

        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node0.neighbors = new ArrayList<>();
        node0.neighbors.add(node2);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node2);

        UndirectedGraphNode res = q.cloneGraph(node1);
        Utils.println(res.label);

    }
}

package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/19.
 */
public class Q95_M_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<>();

        List<TreeNode> res = helper(1, n);

        return res;
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode left : helper(start, i - 1)) {
                for (TreeNode right : helper(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q95_M_Unique_Binary_Search_Trees_II q = new Q95_M_Unique_Binary_Search_Trees_II();
        List<TreeNode> res = q.generateTrees(3);
        Utils.printTreeNodeList(res);
    }
}

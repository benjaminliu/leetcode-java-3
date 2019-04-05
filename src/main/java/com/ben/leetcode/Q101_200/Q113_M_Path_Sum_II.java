package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/26.
 */
public class Q113_M_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        List<Integer> group = new ArrayList<>();
        group.add(root.val);
        helper(root, res, group, root.val, sum, 1);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> group, int temp, int sum, int level) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (temp == sum) {
                res.add(new ArrayList<>(group));
            }
            return;
        }
        if (root.left != null) {
            group.add(root.left.val);
            helper(root.left, res, group, temp + root.left.val, sum, level + 1);
            group.remove(group.size() - 1);
        }
        if (root.right != null) {
            group.add(root.right.val);
            helper(root.right, res, group, temp + root.right.val, sum, level + 1);
            group.remove(group.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q113_M_Path_Sum_II q = new Q113_M_Path_Sum_II();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = q.pathSum(root, 22);
        Utils.printListOfList(res);
    }
}

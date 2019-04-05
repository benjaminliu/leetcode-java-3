package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/19.
 */
public class Q100_E_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null)
                return true;
            return false;
        }
        if (p.val != q.val)
            return false;

        if (!isSameTree(p.left, q.left))
            return false;

        if (!isSameTree(p.right, q.right))
            return false;

        return true;
    }

    public static void main(String[] args) {
        Q100_E_Same_Tree q = new Q100_E_Same_Tree();
        TreeNode t1 = new TreeNode(1);

        TreeNode t2 = null;
        boolean res = q.isSameTree(t1, t2);
        Utils.println(res);
    }

}

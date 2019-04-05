package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/8/26.
 */
public class Q106_M_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length)
            return null;

        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, len - 1, map, 0, len - 1);
    }

    private TreeNode helper(int[] postorder, int pleft, int pright, Map<Integer, Integer> map, int ileft, int iright) {
        if (pleft > pright || ileft > iright)
            return null;

        int value = postorder[pright];
        TreeNode node = new TreeNode(value);

        int rootIdx = map.get(value);
        int len = rootIdx - ileft;
        node.left = helper(postorder, pleft, pleft + len - 1, map, ileft, rootIdx - 1);
        node.right = helper(postorder, pleft + len, pright - 1, map, rootIdx + 1, iright);
        return node;
    }

    public static void main(String[] args) {
        Q106_M_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal q = new Q106_M_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        TreeNode root;

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        root = q.buildTree(inorder, postorder);
        Utils.printTreeNode(root);
    }
}

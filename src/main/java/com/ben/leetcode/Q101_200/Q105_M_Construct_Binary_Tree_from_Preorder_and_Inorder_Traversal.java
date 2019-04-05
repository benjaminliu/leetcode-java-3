package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/8/25.
 */
public class Q105_M_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preoder, int[] inorder) {
        if (inorder.length == 0 || inorder.length != preoder.length)
            return null;

        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return helper(preoder, 0, len - 1, map, 0, len - 1);
    }

    private TreeNode helper(int[] preoder, int pleft, int pright, Map<Integer, Integer> map, int ileft, int iright) {
        if (pleft > pright || ileft > iright)
            return null;
        int value = preoder[pleft];
        TreeNode node = new TreeNode(value);

        int rootIdx = map.get(value);
        int len = rootIdx - ileft;
        node.left = helper(preoder, pleft + 1, pleft + len, map, ileft, rootIdx - 1);
        node.right = helper(preoder, pleft + len + 1, pright, map, rootIdx + 1, iright);

        return node;
    }

    public static void main(String[] args) {
        Q105_M_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal q = new Q105_M_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode root;

        int[] preorder4 = {4, 2, 1, 3};
        int[] inorder4 = {1, 2, 3, 4};
        root = q.buildTree(preorder4, inorder4);
        Utils.printTreeNode(root);


        int[] preorder3 = {1, 2, 3};
        int[] inorder3 = {2, 3, 1};
        root = q.buildTree(preorder3, inorder3);
        Utils.printTreeNode(root);

        int[] preorder2 = {1, 4, 3, 2};
        int[] inorder2 = {1, 2, 3, 4};
        root = q.buildTree(preorder2, inorder2);
        Utils.printTreeNode(root);


        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        root = q.buildTree(preorder, inorder);
        Utils.printTreeNode(root);


    }
}

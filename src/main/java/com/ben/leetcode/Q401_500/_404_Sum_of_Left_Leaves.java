package com.ben.leetcode.Q401_500;

public class _404_Sum_of_Left_Leaves {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        private int sum;

        public int sumOfLeftLeaves(TreeNode root) {
            sum = 0;

            helper(root);
            return sum;
        }

        private void helper(TreeNode root) {
            if (root == null)
                return;

            if (root.left != null) {
                if (root.left.left == null && root.left.right == null)
                    sum += root.left.val;
                else {
                    helper(root.left);
                }
            }
            if (root.right != null) {
                helper(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}

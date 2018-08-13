package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/13.
 */
public class Q78_M_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> group = new ArrayList<>();
        if (nums.length == 1) {
            group.add(nums[0]);
            res.add(group);
            return res;
        }
        int length = nums.length;

        for (int i = 1; i <= length; i++) {
            helper(nums, 0, i, res, group);
        }
        return res;
    }

    private void helper(int[] nums, int idx, int len, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx, end = nums.length; i < end; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, len, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q78_M_Subsets q = new Q78_M_Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = q.subsets(nums);
        Utils.printListOfList(res);
    }
}

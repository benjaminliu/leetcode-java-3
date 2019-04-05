package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2018/8/2.
 */
public class Q39_M_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        Arrays.sort(candidates);

        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, len, res, temp, target);

        return res;
    }

    private void helper(int[] candidates, int idx, int len, List<List<Integer>> res, List<Integer> temp, int target) {
        for (; idx < len; idx++) {
            if (candidates[idx] > target)
                return;
            int a = target - candidates[idx];
            if (a < 0)
                return;
            temp.add(candidates[idx]);
            if (a == 0) {
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
            helper(candidates, idx, len, res, temp, a);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q39_M_Combination_Sum q = new Q39_M_Combination_Sum();
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = q.combinationSum(nums, 7);
        Utils.printListOfList(lists);
    }
}

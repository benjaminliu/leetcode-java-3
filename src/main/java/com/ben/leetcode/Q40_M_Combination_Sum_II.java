package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/8/2.
 */
public class Q40_M_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        for (int i = idx; i < len; i++) {
            if(i > idx && candidates[i] == candidates[i-1])
                continue;
            if (candidates[i] > target)
                return;
            int a = target - candidates[i];
            if (a < 0)
                return;
            temp.add(candidates[i]);
            if (a == 0) {
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
            helper(candidates, i + 1, len, res, temp, a);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q40_M_Combination_Sum_II q = new Q40_M_Combination_Sum_II();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = q.combinationSum2(nums, 8);
        Utils.printListOfList(lists);
    }
}

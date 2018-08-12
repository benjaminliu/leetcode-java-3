package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/12.
 */
public class Q77_M_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n)
            return new ArrayList<>();
        List<Integer> group = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            group.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        if (n == k) {

            res.add(group);
            return res;
        }

        helper(group, 0, k, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(List<Integer> group, int idx, int k, List<List<Integer>> res, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            List<Integer> lists = new ArrayList<>(temp);
            res.add(lists);
        } else {
            for (int i = idx, end = group.size(); i < end; i++) {
                temp.add(group.get(i));
                helper(group, i + 1, k, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q77_M_Combinations q = new Q77_M_Combinations();
        List<List<Integer>> res = q.combine(4, 2);
        Utils.printListOfList(res);
    }
}

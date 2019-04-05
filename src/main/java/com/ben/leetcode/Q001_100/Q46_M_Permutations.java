package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2018/8/5.
 */
public class Q46_M_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        if (nums.length == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> group = new ArrayList<>();
            group.add(nums[0]);
            res.add(group);
            return res;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res,  0, nums.length);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, int start, int len) {
        if (start == len) {
            List<Integer> group = new ArrayList<>();
            for (int i : nums) {
                group.add(i);
            }
            res.add(new ArrayList<>(group));
            return;
        }

        for (int i = start; i < len; i++) {
            swap(nums, start, i);
            helper(nums, res, start + 1, len);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        if (nums.length == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> group = new ArrayList<>();
            group.add(nums[0]);
            res.add(group);
            return res;
        }

        int len = nums.length;
        List<List<Integer>> source = new ArrayList<>();
        List<List<Integer>> target = new ArrayList<>();
        List<List<Integer>> temp;
        List<Integer> group = new ArrayList<>();
        group.add(nums[0]);
        source.add(group);
        for (int i = 1; i < len; i++) {
            int n = nums[i];
            for (List<Integer> item : source) {
                for (int j = 0, end = item.size(); j < end; j++) {
                    group = new ArrayList<>(item);
                    group.add(j, n);
                    target.add(group);
                }
                group = new ArrayList<>(item);
                group.add(n);
                target.add(group);
            }
            temp = source;
            source = target;
            target = temp;
            target.clear();
        }

        return source;
    }


    public static void main(String[] args) {
        Q46_M_Permutations q = new Q46_M_Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = q.permute(nums);
        Utils.printListOfList(res);
    }
}

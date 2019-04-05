package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2018/8/5.
 */
public class Q47_M_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(nums, visited, temp, res);

        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0, len = nums.length; i < len; i++) {
                if (visited[i] == false) {
                    if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)
                        continue;
                    temp.add(nums[i]);
                    visited[i] = true;
                    helper(nums, visited, temp, res);
                    temp.remove(temp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q47_M_Permutations_II q = new Q47_M_Permutations_II();
        int[] nums = {1, 1, 2, 2};
        List<List<Integer>> res = q.permuteUnique(nums);
        Utils.printListOfList(res);
    }
}

package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/8/17.
 */
public class Q90_M_Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        dfs(res, nums, 0, new LinkedList());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, LinkedList<Integer> list) {
        res.add(new LinkedList(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, nums, i + 1, list);
            list.removeLast();

            //remove dup
            while (i != nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
    }


    private Object value = new Object();
    private Map<String, Object> map = new HashMap<>();

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());

        int len = nums.length;
        Arrays.sort(nums);

        List<Integer> group = new LinkedList<>();
        for (int i = 1; i <= len; i++) {
            backtrace(nums, 0, len, res, group, i);
        }
        return res;
    }

    private void backtrace(int[] nums, int idx, int len, List<List<Integer>> res, List<Integer> group, int size) {
        if (group.size() == size) {
            String key = getKey(group);
            if (map.get(key) != null)
                return;

            res.add(new LinkedList<>(group));
            map.put(key, value);
            return;
        }

        for (int i = idx; i < len; i++) {
            group.add(nums[i]);
            backtrace(nums, i + 1, len, res, group, size);
            group.remove(group.size() - 1);
        }
    }

    private String getKey(List<Integer> group) {
        StringBuilder sb = new StringBuilder();
        sb.append(group.get(0));

        for (int i = 1, end = group.size(); i < end; i++) {
            sb.append("-");
            sb.append(group.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q90_M_Subsets_II q = new Q90_M_Subsets_II();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = q.subsetsWithDup(nums);
        Utils.printListOfList(res);
    }
}

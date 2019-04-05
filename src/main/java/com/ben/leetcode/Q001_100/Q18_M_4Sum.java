package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/7/29.
 */
public class Q18_M_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);

        Object value = new Object();
        Map<String, Object> filter = new HashMap<>();
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, endi = len - 3; i < endi; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            for (int j = i + 1, endj = len - 2; j < endj; j++) {
                int twoSum = nums[i] + nums[j];

                if (twoSum + nums[j + 1] + nums[j + 2] > target)
                    break;

                int aid = target - twoSum;
                int x = j + 1;
                int y = len - 1;
                while (x < y) {
                    int sum = nums[x] + nums[y];
                    if (sum == aid) {
                        String key = nums[i] + "," + nums[j] + "," + nums[x] + "," + nums[y];
                        if (filter.get(key) == null) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                            filter.put(key, value);
                        }
                        x++;
                        y--;
                    } else if (sum > aid) {
                        y--;
                    } else {
                        x++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        Q18_M_4Sum q = new Q18_M_4Sum();
        List<List<Integer>> lists = q.fourSum(nums, 12);
        Utils.printListOfList(lists);
    }
}

package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/30.
 */
public class Q31_M_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int last = nums.length - 1;
        int idx = last;
        int end = last;
        while (idx > 0) {
            if (nums[idx] > nums[idx - 1])
                break;
            idx--;
        }
        if (idx == last) {
            int temp = nums[idx];
            nums[idx] = nums[idx - 1];
            nums[idx - 1] = temp;
        } else if (idx == 0) {
            while (idx < end) {
                int temp = nums[idx];
                nums[idx] = nums[end];
                nums[end] = temp;
                idx++;
                end--;
            }
        } else {
            int temp = nums[idx - 1];
            for (int i = end; i >= idx; i--) {
                if (nums[i] > temp) {
                    nums[idx - 1] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }

            while (idx <= end) {
                temp = nums[idx];
                nums[idx] = nums[end];
                nums[end] = temp;
                idx++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Q31_M_Next_Permutation q = new Q31_M_Next_Permutation();
        int[] nums = {1, 2, 3};
        q.nextPermutation(nums);
        Utils.printArray(nums);

        nums = new int[]{3, 2, 1};
        q.nextPermutation(nums);
        Utils.printArray(nums);

        nums = new int[]{1, 1, 5};
        q.nextPermutation(nums);
        Utils.printArray(nums);

        nums = new int[]{1, 3, 2};
        q.nextPermutation(nums);
        Utils.printArray(nums);

        nums = new int[]{2, 3, 1};
        q.nextPermutation(nums);
        Utils.printArray(nums);
    }
}

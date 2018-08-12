package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import javax.rmi.CORBA.Util;

/**
 * Created by ben on 2018/8/12.
 */
public class Q75_M_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums.length < 2)
            return;

        int[] arr = new int[3];
        for (int i : nums) {
            arr[i]++;
        }
        arr[1] += arr[0];
        int idx1 = arr[0];
        int idx2 = arr[1];
        int idx3 = nums.length;
        for (int i = 0; i < idx1; i++) {
            nums[i] = 0;
        }
        for (int i = idx1; i < idx2; i++) {
            nums[i] = 1;
        }
        for (int i = idx2; i < idx3; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        Q75_M_Sort_Colors q = new Q75_M_Sort_Colors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        q.sortColors(nums);
        Utils.printArray(nums);
    }
}

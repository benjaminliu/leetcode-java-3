package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/16.
 */
public class Q88_E_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] >= nums2[idx2]) {
                nums1[idx] = nums1[idx1];
                idx1--;
            } else {
                nums1[idx] = nums2[idx2];
                idx2--;
            }
            idx--;
        }
        while (idx1 >= 0) {
            nums1[idx] = nums1[idx1];
            idx1--;
            idx--;
        }
        while (idx2 >= 0) {
            nums1[idx] = nums2[idx2];
            idx2--;
            idx--;
        }
    }

    public static void main(String[] args) {
        Q88_E_Merge_Sorted_Array q = new Q88_E_Merge_Sorted_Array();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        q.merge(num1, 3, num2, 3);
        Utils.printArray(num1);
    }
}

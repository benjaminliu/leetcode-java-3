package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q66_E_Plus_One {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int increase = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + increase;
            digits[i] = sum % 10;
            increase = sum / 10;
            if (increase == 0)
                break;
        }
        if (increase > 0) {
            int[] res = new int[len + 1];
            res[0] = increase;
            for (int i = 1; i <= len; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        Q66_E_Plus_One q = new Q66_E_Plus_One();
        int[] digits = {1, 2, 3, 4};
        int[] res = q.plusOne(digits);
        Utils.printArray(res);
        int[] digits1 = {9, 9, 9};
        res = q.plusOne(digits1);
        Utils.printArray(res);
        int[] digits2 = { };
        res = q.plusOne(digits2);
        Utils.printArray(res);
    }
}

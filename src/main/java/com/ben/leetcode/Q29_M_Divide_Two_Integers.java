package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/30.
 */
public class Q29_M_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return 0 - dividend;
        }

        long divid = (long) dividend;
        long divis = (long) divisor;

        boolean flag;
        if (divid > 0 && divis > 0) {
            flag = true;
        } else if (divid < 0 && divis < 0) {
            flag = true;
            divid = 0 - divid;
            divis = 0 - divis;
        } else {
            flag = false;
            if (divid < 0) {
                divid = 0 - divid;
            } else {
                divis = 0 - divis;
            }
        }

        if (divid == divis) {
            if (flag)
                return 1;
            return -1;
        }

        int res = 0;
        while (divid >= divis) {
            long temp = divis;
            int multiplay = 1;

            while (divid >= (temp << 1)) {
                temp <<= 1;
                multiplay <<= 1;
            }

            res += multiplay;
            divid -= temp;
        }
        if (flag)
            return res;
        return 0 - res;
    }

    public static void main(String[] args) {
        Q29_M_Divide_Two_Integers q = new Q29_M_Divide_Two_Integers();
        int divide = q.divide(2, 2);
        Utils.print(divide);
    }
}

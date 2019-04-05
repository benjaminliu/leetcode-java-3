package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/5.
 */
public class Q50_M_Pow_X_N {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        if (n < 0) {
            double res = myPow(x, n / 2 * -1);
            if (n % 2 == 0) {
                return 1 / (res * res);
            }
            return 1 / (res * res / x);
        }

        double res = myPow(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        }
        return res * res * x;
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        double half = myPow1(x, n / 2);
        if (n > 0) {
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        } else {
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half / x;
            }
        }
    }

    public static void main(String[] args) {
        Q50_M_Pow_X_N q = new Q50_M_Pow_X_N();
        double res = q.myPow(34.00515, -3);
        Utils.print(res);
    }
}

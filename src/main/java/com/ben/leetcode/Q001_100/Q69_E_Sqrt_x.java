package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q69_E_Sqrt_x {

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            //(mid * mid < x)  &&  ((mid+1) * (mid+1) > x)    return mid;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public int mySqrt2(int x) {
        if (x <= 1)
            return x;

        long left = 0;
        long right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long y = mid * mid;
            if (y == x)
                return (int) mid;
            else if (y > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (int) left - 1;
    }

    public int mySqrt1(int x) {
        if (x <= 1)
            return x;

        long i = 1;
        long lastNo;
        long cur;
        do {
            lastNo = i;
            i++;
            cur = i * i;
            if (x == cur)
                return (int) i;
        } while (x > cur);
        return (int) lastNo;
    }

    public static void main(String[] args) {
        Q69_E_Sqrt_x q = new Q69_E_Sqrt_x();
        int res = q.mySqrt(4);
        Utils.println(res);
        res = q.mySqrt(8);
        Utils.println(res);
    }
}

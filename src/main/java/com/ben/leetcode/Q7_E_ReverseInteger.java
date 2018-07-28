package com.ben.leetcode;

/**
 * Created by ben on 2018/5/20.
 */
public class Q7_E_ReverseInteger {
    public int reverse(int x) {
        if (x == 0)
            return 0;

        long y = x;

        int flag = 1;
        if (x < 0) {
            flag = -1;
            y = y * -1;
        }

        String s = String.valueOf(y);
        char[] cs = s.toCharArray();
        int len = cs.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }

        s = new String(cs);
        y = Long.parseLong(s);

        if (flag == 1) {
            if (y > Integer.MAX_VALUE)
                return 0;
            return (int) y;
        }

        y = y * -1;
        if (y < Integer.MIN_VALUE)
            return 0;
        return (int) y;
    }

    public int reverse1(int x) {

        long s = 0;
        while (x != 0) {
            s = s * 10 + x % 10;
            x /= 10;
        }

        int test = (int) s;
        return s == test ? test : 0;

    }
}

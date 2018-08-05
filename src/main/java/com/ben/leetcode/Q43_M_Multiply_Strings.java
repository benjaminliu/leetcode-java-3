package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/3.
 */
public class Q43_M_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";

        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int totalLen = num1.length() + num2.length();

        int[] res = new int[totalLen];
        int[] m1 = new int[num1.length()];
        for (int i = 0, end = num1.length(); i < end; i++) {
            m1[i] = c2i(num1.charAt(i));
        }

        int multi;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = c2i(num2.charAt(i));
            if (x == 0)
                continue;
            int k = totalLen - (num2.length() - i);
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = m1[j];

                multi = y * x;
                multi += res[k];
                res[k - 1] += multi / 10;
                res[k] = multi % 10;
                k--;
            }
//            Utils.printArray(res);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (res[idx] == 0)
            idx++;
        for (; idx < totalLen; idx++) {
            sb.append(res[idx]);
        }

        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";

        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        if (num1.length() < num2.length())
            multiply(num2, num1);

        int totalLen = num1.length() + num2.length();

        int[] res = new int[totalLen];
        int[] m1 = new int[num1.length()];
        for (int i = 0, end = num1.length(); i < end; i++) {
            m1[i] = c2i(num1.charAt(i));
        }

        int increase = 0;
        int multi;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = c2i(num2.charAt(i));
            if (x == 0)
                continue;
            int k = totalLen - (num2.length() - i);
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = m1[j];
                if (y == 0) {
                    if (increase > 0) {
                        res[k] += increase;
                        increase = res[k] / 10;
                        res[k] = res[k] % 10;
                    }
                    k--;
                    continue;
                }
                multi = y * x;
                multi += increase;
                multi += res[k];
                increase = multi / 10;
                res[k] = multi % 10;
                k--;
            }
            if (increase > 0) {
                res[k] += increase;
                increase = 0;
            }
            Utils.printArray(res);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (res[idx] == 0)
            idx++;
        for (; idx < totalLen; idx++) {
            sb.append(res[idx]);
        }

        return sb.toString();
    }

    private int c2i(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Q43_M_Multiply_Strings q = new Q43_M_Multiply_Strings();
        String res = q.multiply("2309", "6462");
        Utils.println(res);
    }
}

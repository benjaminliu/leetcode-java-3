package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q67_E_Add_Binary {
    public String addBinary(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;

        if (a.length() > b.length())
            return addBinary(b, a);

        int len2 = b.length();
        int[] bs = new int[len2 + 1];
        for (int i = len2 - 1; i >= 0; i--) {
            bs[i + 1] = c2i(b.charAt(i));
        }
        int increase = 0;
        int idxb = len2;
        for (int i = a.length() - 1; i >= 0; i--) {
            int sum = bs[idxb] + c2i(a.charAt(i)) + increase;
            increase = sum / 2;
            bs[idxb] = sum % 2;
            idxb--;
        }
        while (increase > 0) {
            int sum = bs[idxb] + increase;
            increase = sum / 2;
            bs[idxb] = sum % 2;
            idxb--;
        }
        StringBuilder sb = new StringBuilder();
        if (bs[0] > 0) {
            sb.append(bs[0]);
        }
        for (int i = 1; i <= len2; i++) {
            sb.append(bs[i]);
        }
        return sb.toString();
    }

    private int c2i(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Q67_E_Add_Binary q = new Q67_E_Add_Binary();
        String res = q.addBinary("11", "1");
        Utils.println(res);
        res = q.addBinary("1010", "1011");
        Utils.println(res);
    }
}

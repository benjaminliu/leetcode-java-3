package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ben on 2018/8/8.
 */
public class Q60_M_Permutation_Sequence {

    public String getPermutation(int n, int k) {

        List<Integer> set = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            set.add(i);
        }


        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = i * factorial[i - 1];
        }


        k = k - 1;
        StringBuilder out = new StringBuilder();

        for (int i = n; i > 0; i--) {

            int temp = k / factorial[i - 1];
            k = k % factorial[i - 1];
            out.append(set.get(temp));


            set.remove(temp);
        }

        return out.toString();
    }

    public String getPermutation1(int n, int k) {
        if (n == 1)
            return "1";
        if (k == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(i);
            }
            return sb.toString();
        }
        int len = n - 1;
        int[] data = new int[len];
        data[0] = 1;
        for (int i = 2; i < n; i++) {
            data[i - 1] = data[i - 2] * i;
        }

        List<String> cs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            cs.add(String.valueOf(i));
        }

        int idx = len - 1;
        StringBuilder sb = new StringBuilder();
        while (idx >= 0 && k > 0) {
            int temp = (k - 1) / data[idx];
            sb.append(cs.remove(temp));
            k = k - (temp * data[idx]);
            idx--;
        }
        for (String s : cs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q60_M_Permutation_Sequence q = new Q60_M_Permutation_Sequence();
        String res = q.getPermutation(3, 6);
        Utils.print(res);
    }
}

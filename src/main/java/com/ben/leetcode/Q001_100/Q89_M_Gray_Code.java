package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/16.
 */
public class Q89_M_Gray_Code {
    private List<Integer> codes;
    private int current;

    private void generate(int n) {
        for (int i = 0; i < n; i++) {
            current ^= (1 << i);
            codes.add(current);
            if (i > 0) generate(i);
        }
    }

    public List<Integer> grayCode(int n) {
        codes = new ArrayList<>(2 << n);
        current = 0;
        codes.add(current);
        generate(n);
        return codes;
    }


    public static void main(String[] args) {
        Q89_M_Gray_Code q = new Q89_M_Gray_Code();
        List<Integer> res = q.grayCode(4);
        Utils.printList(res);
    }
}

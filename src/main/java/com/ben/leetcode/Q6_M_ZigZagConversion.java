package com.ben.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/5/20.
 */
public class Q6_M_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2)
            return s;

        List<Character>[] rows = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }
        int lastPosition = numRows - 1;
        boolean isNormal = true;
        int rowIdx = 0;
        for (char c : s.toCharArray()) {
            rows[rowIdx].add(c);
            if (isNormal) {
                if (rowIdx == lastPosition) {
                    isNormal = false;
                    rowIdx--;
                } else {
                    rowIdx++;
                }
            } else {
                if (rowIdx == 0) {
                    isNormal = true;
                    rowIdx++;
                } else {
                    rowIdx--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> cs : rows) {
            for (Character c : cs) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

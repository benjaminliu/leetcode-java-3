package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2018/7/29.
 */
public class Q22_M_Generate_Parentheses {

    private final char left = '(';
    private final char right = ')';

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return new ArrayList<>();

        if (n == 1)
            return Arrays.asList("()");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, 0, n, res);
        return res;
    }

    private void helper(StringBuilder sb, int leftCount, int rightCount, int len, List<String> res) {
        if (rightCount > leftCount)
            return;

        if (leftCount == len) {
            while (rightCount < len) {
                sb.append(right);
                rightCount++;
            }
            res.add(sb.toString());
            return;
        }

        int length = sb.length();
        sb.append(left);
        helper(sb, leftCount + 1, rightCount, len, res);
        sb.setLength(length);

        sb.append(right);
        helper(sb, leftCount, rightCount + 1, len, res);
        sb.setLength(length);
    }

    public static void main(String[] args) {
        Q22_M_Generate_Parentheses q = new Q22_M_Generate_Parentheses();
        List<String> strings = q.generateParenthesis(3);
        Utils.printList(strings);
    }
}

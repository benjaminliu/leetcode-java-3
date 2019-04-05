package com.ben.leetcode;

import com.ben.leetcode.util.Utils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import java.util.*;

/**
 * Created by ben on 2018/7/29.
 */
public class Q17_M_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        List<String>[] map = new List[10];
        map[2] = Arrays.asList("a", "b", "c");
        map[3] = Arrays.asList("d", "e", "f");
        map[4] = Arrays.asList("g", "h", "i");
        map[5] = Arrays.asList("j", "k", "l");
        map[6] = Arrays.asList("m", "n", "o");
        map[7] = Arrays.asList("p", "q", "r", "s");
        map[8] = Arrays.asList("t", "u", "v");
        map[9] = Arrays.asList("w", "x", "y", "z");

        int len = digits.length();
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(map, digits, sb, idx, len, res);
        return res;
    }

    private void helper(List<String>[] map, String digits, StringBuilder sb, int idx, int len, List<String> res) {
        if (idx == len)
            return;

        int no = digits.charAt(idx) - '0';
        List<String> list = map[no];
        for (String item : list) {
            sb.append(item);
            if (sb.length() == len) {
                res.add(sb.toString());
            } else {
                helper(map, digits, sb, idx + 1, len, res);
            }

            //remove added item
            sb.setLength(idx);
        }
    }

    public static void main(String[] args) {
        Q17_M_Letter_Combinations_of_a_Phone_Number q = new Q17_M_Letter_Combinations_of_a_Phone_Number();
        String digits = "2";
        List<String> strings = q.letterCombinations(digits);
        Utils.printList(strings);
    }
}

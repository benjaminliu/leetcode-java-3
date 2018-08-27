package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/27.
 */
public class Q118_E_Pascal_s_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;

        List<Integer> group = new ArrayList<>();
        group.add(1);
        res.add(group);
        if (numRows == 1)
            return res;
        group = new ArrayList<>();
        group.add(1);
        group.add(1);
        res.add(group);
        if (numRows == 2)
            return res;

        List<Integer> lastGroup;
        for (int i = 3; i <= numRows; i++) {
            group = new ArrayList<>();
            int k = i - 1;
            lastGroup = res.get(k-1);
            for (int j = 0; j < k; j++) {
                if (j == 0)
                    group.add(1);
                else
                    group.add(lastGroup.get(j - 1) + lastGroup.get(j));
            }
            group.add(1);
            res.add(group);
        }
        return res;
    }

    public static void main(String[] args) {
        Q118_E_Pascal_s_Triangle q = new Q118_E_Pascal_s_Triangle();
        List<List<Integer>> res = q.generate(5);
        Utils.printListOfList(res);
    }
}

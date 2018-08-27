package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/27.
 */
public class Q119_E_Pascal_s_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0)
            return res;
        for (int i = 0; i < rowIndex; i++) {
            res.add(0);
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >0; --j) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q119_E_Pascal_s_Triangle_II q = new Q119_E_Pascal_s_Triangle_II();
        List<Integer> row = q.getRow(4);
        Utils.printList(row);
    }
}

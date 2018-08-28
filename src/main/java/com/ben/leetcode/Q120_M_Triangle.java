package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/28.
 */
public class Q120_M_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int len = triangle.size();
        List<Integer> last = triangle.get(len - 1);
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = last.get(i);
        }
        for (int i = 0, end = len - 1; i < end; i++) {
            for (int j = 0; j < end - i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(end - 1 - i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Q120_M_Triangle q = new Q120_M_Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        group.add(-1);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(2);
        group.add(3);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(1);
        group.add(-1);
        group.add(-3);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(5);
        group.add(3);
        group.add(-1);
        group.add(2);
        triangle.add(group);
        int res = q.minimumTotal(triangle);
        Utils.println(res);

        triangle = new ArrayList<>();
        group = new ArrayList<>();
        group.add(2);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(3);
        group.add(4);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(6);
        group.add(5);
        group.add(7);
        triangle.add(group);
        group = new ArrayList<>();
        group.add(4);
        group.add(1);
        group.add(8);
        group.add(3);
        triangle.add(group);
        res = q.minimumTotal(triangle);
        Utils.println(res);
    }
}

package com.ben.leetcode.Q301_400;

import java.util.ArrayList;
import java.util.List;

public class _386_Lexicographical_Numbers {
    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(i, n, res);
            }
            return res;
        }

        private void dfs(int i, int n, List<Integer> res) {
            if (i > n)
                return;

            res.add(i);

            for (int j = 0; j < 10; j++) {
                int temp = 10 * i + j;
                if (temp > n)
                    return;
                dfs(temp, n, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(13));
    }
}

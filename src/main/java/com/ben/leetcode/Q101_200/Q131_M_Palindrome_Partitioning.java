package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/9/1.
 */
public class Q131_M_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;

        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(String s, int start, ArrayList<String> group, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(group));
            return;
        }
        for (int i = start, end = s.length(); i < end; i++) {
            if (isPalindrome(s, start, i)) {
                group.add(s.substring(start, i + 1));
                dfs(s, i + 1, group, res);
                group.remove(group.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q131_M_Palindrome_Partitioning q = new Q131_M_Palindrome_Partitioning();
        List<List<String>> res = q.partition("aab");
        Utils.printListOfList(res);

        q.isPalindrome("bbab", 0, 3);
    }
}

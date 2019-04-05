package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/8/5.
 */
public class Q49_M_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        if (strs.length == 1) {
            List<List<String>> res = new ArrayList<>();
            List<String> group = new ArrayList<>();
            group.add(strs[0]);
            res.add(group);
            return res;
        }

        int[] alpha = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                alpha[c2i(c)]++;
            }
            String temp = toStr(alpha);
            List<String> orDefault = map.getOrDefault(temp, new ArrayList<>());
            orDefault.add(s);
            map.put(temp, orDefault);
            for (int i = 0; i < 26; i++) {
                alpha[i] = 0;
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String toStr(int[] alpha) {
        StringBuilder sb = new StringBuilder();
        for (int i : alpha) {
            sb.append(i);
            sb.append("-");
        }
        return sb.toString();
    }

    private int c2i(char c) {
        return c - 'a';
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        Q49_M_Group_Anagrams q = new Q49_M_Group_Anagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = q.groupAnagrams(strs);
        Utils.printListOfList(res);
    }
}

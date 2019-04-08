package com.ben.leetcode.Q301_400;

import java.util.*;

public class _387_First_Unique_Character_in_a_String {

    static class Entity {
        char c;
        int idx;
        int count;

        public void Entity(char c, int idx) {
            this.c = c;
            this.idx = idx;
            this.count = 1;
        }
    }

    static class Solution {
        public int firstUniqChar(String s) {
            if (s.length() == 0)
                return 0;
            if (s.length() == 1)
                return 0;

            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> idxMap = new HashMap<>();

            List<Character> list = new ArrayList<>();

            for (int i = 0, end = s.length(); i < end; i++) {
                char c = s.charAt(i);
                Integer count = map.get(c);
                if (count == null) {
                    map.put(c, 1);
                    idxMap.put(c, i);
                    list.add(c);
                } else {
                    map.put(c, count + 1);
                }
            }

            for (char c : list) {
                if (map.get(c) == 1) {
                    return idxMap.get(c);
                }
            }
            return -1;
        }

        public int firstUniqChar1(String s) {
            int[] map = new int[26];
            char[] charMap = s.toCharArray();
            for (char c : charMap) {
                map[c - 'a']++;
            }

            for (int i = 0; i < charMap.length; i++) {
                if (map[charMap[i] - 'a'] == 1)
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("z"));
    }
}

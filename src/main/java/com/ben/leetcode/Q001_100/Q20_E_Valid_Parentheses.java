package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ben on 2018/7/29.
 */
public class Q20_E_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', '0');
        map.put('[', '0');
        map.put('{', '0');
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Character value = map.get(c);
            if (value == null)
                continue;
            if (value == '0')
                stack.addFirst(c);
            else {
                if (stack.isEmpty() || stack.peekFirst() != value)
                    return false;
                stack.pollFirst();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Q20_E_Valid_Parentheses q = new Q20_E_Valid_Parentheses();
        boolean valid = q.isValid("([)]");
        Utils.print(valid);

    }
}

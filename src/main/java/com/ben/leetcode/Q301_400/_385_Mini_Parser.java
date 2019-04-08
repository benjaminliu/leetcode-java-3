package com.ben.leetcode.Q301_400;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

public class _385_Mini_Parser {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public static class NestedInteger {
        private boolean isNum;
        private Integer num;
        private List<NestedInteger> list;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            list = new ArrayList<>();
            isNum = false;
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.num = value;
            isNum = true;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return num;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.num = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            this.list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            if (this.isNum) {
                return String.valueOf(num);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (NestedInteger item : this.list) {
                sb.append(item.toString());
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }
    }

    static class Solution {

        private int position;

        public NestedInteger deserialize(String s) {
            if (s.charAt(0) != '[') {
                int i = Integer.parseInt(s);
                return new NestedInteger(i);
            }
            position = 0;
            NestedInteger res = new NestedInteger();
            helper(s, s.length(), res);
            return res.getList().get(0);
        }

        private void helper(String s, int len, NestedInteger res) {

            boolean hasNo = false;
            int temp = 0;
            int flag = 1;
            while (position < len) {
                char c = s.charAt(position);
                position++;
                if (c == '-') {
                    flag = -1;
                } else if (c == '[') {
                    //list
                    NestedInteger item = new NestedInteger();
                    res.add(item);
                    helper(s, len, item);
                } else if (c == ']') {
                    if (hasNo == true) {
                        NestedInteger item = new NestedInteger(temp * flag);
                        res.add(item);
                        flag = 1;
                    }
                    return;
                } else if (c == ',') {
                    if (hasNo == true) {
                        NestedInteger item = new NestedInteger(temp * flag);
                        res.add(item);
                        temp = 0;
                        flag = 1;
                        hasNo = false;
                    }
                } else {
                    //num
                    hasNo = true;
                    temp = temp * 10 + c - '0';
                }
            }
            if (hasNo == true) {
                NestedInteger item = new NestedInteger(temp * flag);
                res.add(item);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deserialize("213"));
        System.out.println(solution.deserialize("[123,[456,[789]]]"));
    }
}

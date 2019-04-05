package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/2.
 */
public class Q38_E_Count_and_Say {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        StringBuilder source = new StringBuilder();
        StringBuilder target = new StringBuilder();
        StringBuilder temp;

        source.append("1");
        int idx = 1;
        while (idx++ < n) {
            int count = 1;
            char lastChar = source.charAt(0);
            for (int i = 1, end = source.length(); i < end; i++) {
                if (source.charAt(i) == lastChar) {
                    count++;
                } else {
                    target.append(count);
                    target.append(lastChar);
                    lastChar = source.charAt(i);
                    count = 1;
                }
            }
            target.append(count);
            target.append(lastChar);

            temp = target;
            target = source;
            source = temp;
            target.setLength(0);
        }
        return source.toString();
    }

    public static void main(String[] args) {
        Q38_E_Count_and_Say q = new Q38_E_Count_and_Say();
        String res = q.countAndSay(2);
        Utils.println(res);
        res = q.countAndSay(3);
        Utils.println(res);
        res = q.countAndSay(4);
        Utils.println(res);
        res = q.countAndSay(5);
        Utils.println(res);
        res = q.countAndSay(6);
        Utils.println(res);
    }
}

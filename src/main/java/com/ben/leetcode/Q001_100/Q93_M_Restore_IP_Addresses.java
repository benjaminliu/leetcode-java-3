package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/18.
 */
public class Q93_M_Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }

    private void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty())
                res.add(out);
            return;
        }
        for (int k = 1; k < 4; k++) {
            if (s.length() < k)
                break;
            if (k > 1 && s.charAt(0) == '0')
                break;
            String temp = s.substring(0, k);
            int val = Integer.parseInt(temp);
            if (val > 255)
                continue;
            helper(s.substring(k), n + 1, out + temp + (n == 3 ? "" : "."), res);
        }
    }

    public static void main(String[] args) {
        Q93_M_Restore_IP_Addresses q = new Q93_M_Restore_IP_Addresses();
        List<String> res = q.restoreIpAddresses("25525511135");
        Utils.printList(res);
    }
}

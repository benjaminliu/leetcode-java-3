package com.ben.leetcode;

/**
 * Created by ben on 2018/7/28.
 */
public class Q12_M_Integer_to_Roman {
    public String intToRoman(int num) {
        String[] mapValue = {"MMM", "MM", "M",
                "CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C",
                "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X",
                "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"
        };
        int[] mapKey = {3000, 2000, 1000,
                900, 800, 700, 600, 500, 400, 300, 200, 100,
                90, 80, 70, 60, 50, 40, 30, 20, 10,
                9, 8, 7, 6, 5, 4, 3, 2, 1
        };

        StringBuilder sb = new StringBuilder();
        int len = mapKey.length;
        for (int i = 0; i < len; i++) {
            if (num >= mapKey[i]) {
                sb.append(mapValue[i]);
                num -= mapKey[i];
            }
        }
        return sb.toString();
    }

    public String intToRoman1(int num) {
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                sb.append(strs[i]);
                num = num - nums[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q12_M_Integer_to_Roman q = new Q12_M_Integer_to_Roman();
        String res = q.intToRoman(1994);
        System.out.println(res);
    }
}

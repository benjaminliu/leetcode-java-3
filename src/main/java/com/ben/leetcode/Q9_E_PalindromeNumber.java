package com.ben.leetcode;

/**
 * Created by ben on 2018/5/20.
 */
public class Q9_E_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x == 0)
            return true;

        int y = 0;

        int temp = x;
        while (temp > 0 ){
            int cur = temp %10;
            temp = temp /10;
            y = y*10 + cur;
        }
        return y == x;
    }
}

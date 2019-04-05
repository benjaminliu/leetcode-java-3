package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/9/4.
 */
public class Q139_M_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] words = new boolean[length];

        for(int i = 1;i<=length;i++){
            int j;
            for(j = 0;j<i;j++){
                String substr = s.substring(j,i);
                if(wordDict.contains(substr) && (j==0 || words[j-1])) {
                    words[i-1] = true;
                    break;
                }
            }
            if(j == i)
                words[i-1] = false;
        }
        return words[length-1];
    }

    public static void main(String[] args) {
        Q139_M_Word_Break q = new Q139_M_Word_Break();
        List<String> list = Arrays.asList("leet", "code");
        boolean res = q.wordBreak("leetcode", list);
        Utils.println(res);

        list = Arrays.asList("apple", "pen");
        res = q.wordBreak("applepenapple", list);
        Utils.println(res);


        list = Arrays.asList("cats", "dog", "sand", "and", "cat");
        res = q.wordBreak("catsandog", list);
        Utils.println(res);

        list = Arrays.asList("aaaa", "aaa");
        res = q.wordBreak("aaaaaaa", list);
        Utils.println(res);
    }
}

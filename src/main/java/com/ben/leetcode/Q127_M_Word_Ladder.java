package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/8/30.
 */
public class Q127_M_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0)
            return 0;
        if (beginWord.length() == 0)
            return 0;

        int len = wordList.size();

        int[] visited = new int[len];
        boolean endExist = false;
        for (int i = 0; i < len; i++) {
            if (endWord.equals(wordList.get(i))) {
                visited[i] = 1;
                endExist = true;
                break;
            }
        }
        if (endExist == false)
            return 0;

        int leftRoute = 0;
        int rightRoute = 0;
        Queue<String> leftQueue = new LinkedList<>();
        leftQueue.add(beginWord);
        Queue<String> rightQueue = new LinkedList<>();
        rightQueue.add(endWord);

        while (true) {
            int leftSize = leftQueue.size();

            for (int i = 0; i < leftSize; i++) {
                String cur = leftQueue.poll();
                for (int j = 0; j < len; j++) {
                    if (visited[j] == -1)
                        continue;

                    String temp = wordList.get(j);
                    if (oneDiff(cur, temp)) {
                        if (visited[j] == 1)
                            return leftRoute + rightRoute + 2;

                        leftQueue.add(temp);
                        visited[j] = -1;
                    }
                }
            }
            if (leftQueue.isEmpty())
                return 0;
            leftRoute++;

            int rightSize = rightQueue.size();

            for (int i = 0; i < rightSize; i++) {
                String cur = rightQueue.poll();
                for (int j = 0; j < len; j++) {
                    if (visited[j] == 1)
                        continue;
                    String temp = wordList.get(j);
                    if (oneDiff(cur, temp)) {
                        if (visited[j] == -1)
                            return leftRoute + rightRoute + 2;

                        rightQueue.add(temp);
                        visited[j] = 1;
                    }
                }
            }
            if (rightQueue.isEmpty())
                return 0;
            rightRoute++;
        }
    }

    private boolean oneDiff(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        if (diff == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> wordList;
        int res;
        Q127_M_Word_Ladder q = new Q127_M_Word_Ladder();

//        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        res = q.ladderLength("hit", "cog", wordList);
//        Utils.println(res);

        wordList = Arrays.asList("a", "b", "c");
        res = q.ladderLength("a", "c", wordList);
        Utils.println(res);
    }
}

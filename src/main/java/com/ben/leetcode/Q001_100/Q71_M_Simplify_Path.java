package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ben on 2018/8/12.
 */
public class Q71_M_Simplify_Path {
    public String simplifyPath(String path) {
        int start = 0;
        int end = path.length();
        while (start < end && path.charAt(start) == '/')
            start++;
        if (start == end)
            return "/";

        while (path.charAt(end - 1) == '/')
            end--;
        path = path.substring(start, end);
        String[] paths = path.split("/");
        Deque<String> stack= new LinkedList<>();
        for(String p : paths){
            if("." .equals(p))
                continue;
            if("..".equals(p)){
                if(stack.isEmpty()){

                }else {
                    stack.pollLast();
                }
            }else {
                if("".equals(p))
                    continue;
                stack.addLast(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        if(sb.length()==0)
            return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        Q71_M_Simplify_Path q = new Q71_M_Simplify_Path();
        String res = q.simplifyPath("/a/./b/../../c/");
        Utils.println(res);
        res = q.simplifyPath("/");
        Utils.println(res);

        res = q.simplifyPath("/a/./b/../..///c/");
        Utils.println(res);

    }
}

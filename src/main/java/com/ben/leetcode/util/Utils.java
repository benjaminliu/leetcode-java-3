package com.ben.leetcode.util;

import java.util.List;

/**
 * Created by ben on 2018/7/28.
 */
public class Utils {
    public static <T> void printList(List<T> list) {
        if (list == null)
            return;

        for (T item : list) {
            System.out.print(item);
            System.out.print(" , ");
        }
    }

    public static <T> void printListOfList(List<List<T>> list) {
        if (list == null)
            return;

        for (List<T> group : list) {
            printList(group);
            System.out.println();
        }
    }
}

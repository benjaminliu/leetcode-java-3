package com.ben.leetcode;

import com.ben.leetcode.common.Interval;
import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ben on 2018/8/7.
 */
public class Q56_M_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                if (o1.start > o2.start)
                    return 1;

                if (o1.end < o2.end)
                    return -1;
                if (o1.end > o2.end)
                    return 1;

                return 0;
            }
        });

        List<Interval> res = new ArrayList<>();
        Interval last = intervals.get(0);
        int len = intervals.size();
        for (int i = 1; i < len; i++) {
            Interval cur = intervals.get(i);
            if (cur.start > last.end) {
                res.add(last);
                last = cur;
            } else {
                if (cur.end > last.end) {
                    last.end = cur.end;
                }
            }
        }
        res.add(last);
        return res;
    }

    public static void main(String[] args) {
        Q56_M_Merge_Intervals q = new Q56_M_Merge_Intervals();
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 3));
//        intervals.add(new Interval(2, 6));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(15, 18));

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(4, 5));
        List<Interval> res = q.merge(intervals);
        Utils.printList(res);

    }
}

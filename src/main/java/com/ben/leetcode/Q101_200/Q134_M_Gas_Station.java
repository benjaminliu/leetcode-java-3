package com.ben.leetcode;

/**
 * Created by ben on 2018/9/2.
 */
public class Q134_M_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return -1;

        int len = gas.length;
        int tank = 0;
        int startIdx = 0;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < len; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                startIdx = i + 1;
            }
        }
        if (gasSum >= costSum) {
            return startIdx;
        }
        return -1;
    }
}

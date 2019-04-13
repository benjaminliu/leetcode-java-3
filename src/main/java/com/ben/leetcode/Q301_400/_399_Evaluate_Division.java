package com.ben.leetcode.Q301_400;

import java.util.*;

public class _399_Evaluate_Division {
    static class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, List<String>> pairs = new HashMap<>();
            Map<String, List<Double>> valuesPairs = new HashMap<>();

            for (int i = 0; i < equations.length; i++) {
                String[] equation = equations[i];
                List<String> value1 = pairs.get(equation[0]);
                List<Double> value11 = null;
                if (value1 == null) {
                    value1 = new ArrayList<>();
                    value11 = new ArrayList<>();
                    pairs.put(equation[0], value1);
                    valuesPairs.put(equation[0], value11);
                } else {
                    value11 = valuesPairs.get(equation[0]);
                }
                value1.add(equation[1]);
                value11.add(values[i]);

                List<String> value2 = pairs.get(equation[1]);
                List<Double> value22 = null;
                if (value2 == null) {
                    value2 = new ArrayList<>();
                    value22 = new ArrayList<>();
                    pairs.put(equation[1], value2);
                    valuesPairs.put(equation[1], value22);
                } else {
                    value22 = valuesPairs.get(equation[1]);
                }
                value2.add(equation[0]);
                value22.add(1 / values[i]);
            }

            double[] res = new double[queries.length];
            for (int i = 0; i < queries.length; i++) {
                String[] query = queries[i];
                res[i] = dfs(query[0], query[1], pairs, valuesPairs, new HashSet<String>(), 1.0);
                if (res[i] == 0.0)
                    res[i] = -1.0;
            }
            return res;
        }

        private double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> valuesPairs, HashSet<String> set, double value) {

            if (set.contains(start))
                return 0.0;
            List<String> value1 = pairs.get(start);
            if (value1 == null)
                return 0.0;

            if (start.equals(end))
                return value;

            set.add(start);

            List<Double> value2 = valuesPairs.get(start);
            double temp = 0.0;
            for (int i = 0; i < value1.size(); i++) {
                temp = dfs(value1.get(i), end, pairs, valuesPairs, set, value * value2.get(i));
                if (temp != 0.0)
                    break;
            }

            set.remove(start);
            return temp;
        }
    }
}

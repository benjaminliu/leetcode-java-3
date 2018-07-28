package com.ben.leetcode.codeM;

import java.util.*;

/**
 * Created by ben on 2018/5/26.
 */
public class Supermaket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int row2 = sc.nextInt();

        if (row1 == 0) {
            System.out.println("0.00");
            return;
        }

        int[] prices = new int[row1];
        double totalPriceWith8Discount10 = 0;
        long totalPriceWithout8Discount = 0;
        int can8Discount;
        for (int i = 0; i < row1; i++) {

            prices[i] = sc.nextInt();
            can8Discount = sc.nextInt();
            if (can8Discount == 1) {
                totalPriceWith8Discount10 += prices[i] * 0.8;
            } else {
                totalPriceWith8Discount10 += prices[i];
            }
            totalPriceWithout8Discount += prices[i];
        }

        double totalPriceWith8Discount = (double) totalPriceWith8Discount10 ;
        double result = totalPriceWith8Discount;

        if (row2 != 0) {
            TreeMap<Integer, Integer> discount = new TreeMap<>();
            for (int i = 0; i < row2; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                discount.put(a, b);
            }

            Map.Entry<Integer, Integer> lastEntry = null;
            for (Map.Entry<Integer, Integer> entry : discount.entrySet()) {
                if (entry.getKey() > totalPriceWithout8Discount) {
                    break;
                } else {
                    lastEntry = entry;
                }
            }
            if (lastEntry != null) {
                double temp = totalPriceWithout8Discount - lastEntry.getValue();
                if (temp < totalPriceWith8Discount) {
                    result = temp;
                }
            }
        }

        System.out.println(String.format("%.2f", result));
    }
}

package com.ben.leetcode.codeM;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ben on 2018/5/26.
 */
public class MedoC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int round = sc.nextInt();
        int promotionCount = sc.nextInt();
        int lostScoreMax = sc.nextInt();

        double[] roundWeight = new double[round];
        int totalWeight = 0;
        for (int i = 0; i < round; i++) {
            roundWeight[i] = sc.nextInt();
            totalWeight += roundWeight[i];
        }
        for (int i = 0; i < round; i++) {
            roundWeight[i] = roundWeight[i] / totalWeight;
        }

        double[][] scores = new double[peopleCount][round];
        double[] roundMax = new double[round];

        int specialPeople = 0;
        int specialRound = 0;
        for (int i = 0; i < peopleCount; i++) {
            for (int j = 0; j < round; j++) {
                int score = sc.nextInt();
                if (score != -1) {
                    scores[i][j] = score;
                    if (scores[i][j] > roundMax[j]) {
                        roundMax[j] = scores[i][j];
                    }
                } else {
                    scores[i][j] = -1;
                    specialPeople = i;
                    specialRound = j;
                }
            }
        }

        double[] totalScores = new double[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            for (int j = 0; j < round; j++) {
                if (roundMax[j] == 0) {
                    continue;
                }

                if (scores[i][j] == -1)
                    continue;

                totalScores[i] += scores[i][j] / roundMax[j] * roundWeight[j];
            }
        }

        double specialScore = totalScores[specialPeople];
        double specialMaxScore = specialScore + lostScoreMax / roundMax[specialRound] * roundWeight[specialRound];

        PriorityQueue<Double> minHeap = new PriorityQueue<>(promotionCount);

        int idx = 0;
        while (idx < promotionCount) {
            minHeap.add(totalScores[idx]);
            idx++;
        }
        while (idx < peopleCount) {
            if (totalScores[idx] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(totalScores[idx]);
            }
            idx++;
        }
        double promotionScore = minHeap.poll();

        //没有不能确认的情况
        if (specialScore > promotionScore || specialMaxScore < promotionScore) {
            for (double d : totalScores) {
                if (d >= promotionScore) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
        } else {
            double secondToPromotionScore = minHeap.poll();
            for (int i = 0; i < peopleCount; i++) {
                if (i == specialPeople) {
                    System.out.println("3");
                } else if (totalScores[i] >= secondToPromotionScore) {
                    System.out.println("1");
                } else if (totalScores[i] < promotionScore) {
                    System.out.println("2");
                } else {
                    System.out.println("3");
                }
            }
        }
    }
}

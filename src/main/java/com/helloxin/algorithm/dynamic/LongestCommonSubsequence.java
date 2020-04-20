package com.helloxin.algorithm.dynamic;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String wordA = "hish";
        String wordB = "fish";
        int[][] cell = new int[wordA.length()][wordB.length()];

        for (int i = 0; i < wordA.length(); i++) {
            for (int j = 0; j < wordB.length(); j++) {
                // The letters match
                if (wordA.charAt(i) == wordB.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    // The letters don't match.
                    if (i == 0 && j > 0) {
                        cell[i][j] = cell[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        cell[i][j] = cell[i - 1][j];
                    } else if (i > 0 && j > 0) {
                        cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }
        printResult(cell);
    }

    private static void printResult(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

}

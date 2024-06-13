package cn.lqs.leetcode_1000_2000.leetcode_1686;

import java.util.Arrays;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        if (n == 1) {
            return 1;
        }
        int[] weight = new int[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            weight[i] = aliceValues[i] + bobValues[i];
            idx[i] = i;
        }
        Arrays.sort(idx, (prev, next) -> weight[next] - weight[prev]);
        int aliceWeight = 0, bobWeight = 0;
        for (int i = 0; i < n;) {
            aliceWeight += aliceValues[idx[i]];
            i++;
            if (i < n) {
                bobWeight += bobValues[idx[i]];
                i++;
            }
        }
        if (aliceWeight == bobWeight) {
            return 0;
        }
        return aliceWeight > bobWeight ? 1 : -1;
    }

    public static void main(String[] args) {
        new Solution().stoneGameVI(
                new int[]{40, 76, 27, 31, 40, 12, 57, 10, 88, 72, 85, 5, 28, 25, 61, 82, 16, 63, 50, 90, 20, 55, 63},
                new int[]{74, 5, 37, 21, 29, 59, 94, 25, 31, 10, 86, 31, 99, 45, 77, 91, 44, 73, 83, 67, 55, 12, 35}
        );
    }

}
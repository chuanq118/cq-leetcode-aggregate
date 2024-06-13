package cn.lqs.leetcode_1000_2000.leetcode_1277;

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int[] sideLens = new int[Math.min(m, n) + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1;
                }
                for (int k = 1; k <= dp[i + 1][j + 1]; k++) {
                    sideLens[k] += 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < sideLens.length; i++) {
            ans += sideLens[i];
        }
        return ans;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}

package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i + 1][j + 1] = 0;
                }else{
                    dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1;
                }
                ans = Math.max(ans, dp[i + 1][j + 1]);
            }
        }
        return ans * ans;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
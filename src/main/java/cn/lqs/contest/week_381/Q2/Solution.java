package cn.lqs.contest.week_381.Q2;

class Solution {
    public long[] countOfPairs(int n, int x, int y) {
        int[][] dp = new int[n + 1][n + 1];
        long[] result = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else if (Math.abs(i - j) == 1 || (i == x && j == y) || (i == y && j == x)) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = n;
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                result[dp[i][j]]++;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            result[i] += result[i-1];
        }
        for (int i = n; i > 0; i--) {
            result[i] = result[i] - result[i-1];
        }
        long[] ans = new long[result.length-1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result[i+1] * 2;
        }
        return ans;
    }
}
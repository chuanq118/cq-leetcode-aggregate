package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_494;

import java.util.HashMap;
import java.util.Map;

class SolutionDP {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += target;
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        int val = sum / 2;
        int[][] dp = new int[nums.length+1][val+1];
        dp[0][0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= val; j++) {
                if (j < nums[i]) {
                    dp[i+1][j] = dp[i][j];
                }else{
                    dp[i+1][j] = dp[i][j] + dp[i][j-nums[i]];
                }
            }
        }
        return dp[nums.length][val];
    }

}
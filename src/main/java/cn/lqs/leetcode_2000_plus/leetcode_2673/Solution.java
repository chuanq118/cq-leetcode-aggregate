package cn.lqs.leetcode_2000_plus.leetcode_2673;

class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n; i > 1; i -= 2) {
            ans += Math.abs(cost[i - 1] - cost[i - 2]);
            cost[i / 2 - 1] += Math.max(cost[i - 1], cost[i - 2]);
        }
        return ans;
    }
}
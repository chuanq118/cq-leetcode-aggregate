package cn.lqs.leetcode_2000_plus.leetcode_2644;

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0;
        int maxC = 0;
        int minDivisor = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            minDivisor = Math.min(minDivisor, divisor);
            int c = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    c += 1;
                }
            }
            if (c > maxC) {
                ans = divisor;
                maxC = c;
            } else if (c == maxC && divisor < ans) {
                ans = divisor;
            }
        }
        return ans == 0 ? minDivisor : ans;
    }
}
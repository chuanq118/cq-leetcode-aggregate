package cn.lqs.contest.week_d_133.q1;

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for (int num : nums) {
            int remainder = num % 3;
            if (remainder == 1) {
                operations += 1;
            } else if (remainder == 2) {
                operations += 1;
            }
        }
        return operations;
    }
}
package cn.lqs.contest.week_d_133.q3;

class Solution {
    public int minOperations(int[] nums) {
        int op = 0;
        int n = nums.length;
        boolean flipped = false;
        for (int i = 0; i < n; i++) {
            if ((!flipped && nums[i] == 0) || (flipped && nums[i] == 1)) {
                op += 1;
                flipped = !flipped;
            }
        }
        return op;
    }
}
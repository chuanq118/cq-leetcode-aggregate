package cn.lqs.contest.week_d_133.q2;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minOp = 0;
        for (int i = 0; i < n - 2; i += 1) {
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                minOp += 1;
            }
        }
        for (int i = n - 2; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return minOp;
    }
}

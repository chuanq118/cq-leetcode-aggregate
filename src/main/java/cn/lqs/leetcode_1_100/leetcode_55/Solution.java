package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_55;

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int target = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = i + nums[i];
            if (max >= target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        System.out.println(solution.canJump(nums));
    }

}
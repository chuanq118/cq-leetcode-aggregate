package cn.lqs.leetcode_45;

class Solution {
    public int jump(int[] nums) {
        int maxPos = 0;
        int[] minSteps = new int[nums.length];
        minSteps[0] = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int curMaxPos = i + nums[i];
            if (curMaxPos > maxPos) {
                int minStep = minSteps[i] + 1;
                for (int j = maxPos + 1; j < nums.length && j <= curMaxPos; j++) {
                    minSteps[j] = minStep;
                }
                maxPos = curMaxPos;
            }
            if (maxPos >= nums.length - 1) {
                result = i == nums.length - 1 ? minSteps[i] : minSteps[i] + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 4, 0, 1, 3, 6, 8, 0, 9, 4, 9, 1, 8, 7, 4, 8};
        System.out.println(solution.jump(nums));
    }
}
package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diffAbs = Integer.MAX_VALUE;
        int diffVal = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = minDiff(i + 1, target - nums[i], nums);
            if (diff == 0) {
                return target;
            }
            if (Math.abs(diff) < diffAbs) {
                diffVal = diff;
                diffAbs = Math.abs(diff);
            }
        }
        return target + diffVal;
    }

    public int minDiff(int pi, int tar, int[] nums) {
        int l = pi, r = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        int diffVal = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            int curDiff = Math.abs(sum - tar);
            if (curDiff == 0) {
                return 0;
            }
            if (curDiff < diff) {
                diff = curDiff;
                diffVal = sum - tar;
            }
            if (sum < tar) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        return diffVal;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 1, 1, 0
        };
        int target = -100;
        new Solution().threeSumClosest(nums, target);
    }
}

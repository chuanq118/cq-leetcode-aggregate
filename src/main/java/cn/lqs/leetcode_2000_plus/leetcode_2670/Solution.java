package cn.lqs.leetcode_2000_plus.leetcode_2670;

import java.util.HashSet;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] preDiffers = new int[nums.length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            preDiffers[i] = set.size();
        }
        set.clear();
        int[] postDiffers = new int[nums.length];
        for (int i = nums.length - 1; i > -1; i--) {
            set.add(nums[i]);
            postDiffers[i] = set.size();
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length - 1; i++) {
            ans[i] = preDiffers[i] - postDiffers[i+1];
        }
        ans[ans.length - 1] = preDiffers[ans.length - 1];
        return ans;
    }
}
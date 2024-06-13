package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_494;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] nums;
    Map<String, Integer> cache;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += target;
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        this.nums = nums;
        this.cache = new HashMap<>();
        return dfs(nums.length - 1, sum / 2);
    }

    private int dfs(int i, int val) {
        if (i < 0) return val == 0 ? 1 : 0;
        String key = String.valueOf(i) + "#" + String.valueOf(val);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int max = dfs(i - 1, val) + dfs(i - 1, val - nums[i]);
        cache.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47};
        int targetSumWays = new Solution().findTargetSumWays(arr, 38);
        System.out.println("targetSumWays = " + targetSumWays);
    }
}
package cn.lqs.contest.week_382;

import java.util.HashMap;

public class S4 {

    int[] nums;
    int maxK;
    HashMap<String, Integer> cache;

    public int minOrAfterOperations(int[] nums, int k) {
        this.nums = nums;
        this.maxK = k;
        this.cache = new HashMap<>();
        return 0;
    }

    private int dfs(int l, int r, int k) {
        if (k > maxK) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = l + 1; i <= r; i++) {
            // 状态转移
            res = Math.min(res, (nums[i - 1] & nums[i]) | dfs(i + 1, r, k - (i - l)));
        }
        return 0;

    }
}

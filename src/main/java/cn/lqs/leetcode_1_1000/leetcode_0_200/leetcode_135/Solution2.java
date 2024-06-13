package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_135;

public class Solution2 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        int ans = 0;
        int next = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = ratings[i] > ratings[i+1] ? next + 1 : 1;
            next = cur;
            ans += Math.max(cur, left[i]);
        }
        ans += left[ratings.length - 1];
        return ans;
    }

}

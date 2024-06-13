package cn.lqs.leetcode_2000_plus.leetcode_2639;

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i += 1) {
            for (int[] ints : grid) {
                ans[i] = Math.max(getLen(ints[i]), ans[i]);
            }
        }
        return ans;
    }

    private int getLen(int num) {
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        int c = 1;
        while (num >= 10) {
            num /= 10;
            c += 1;
        }
        return isNegative ? c + 1 : c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getLen(1000000000));
    }
}
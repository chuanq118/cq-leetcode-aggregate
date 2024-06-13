package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_435;

import java.util.Arrays;

class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (prev, next) -> {
            return prev[0] - next[0];
        });
        return 0;
    }
}
package cn.lqs.leetcode_1_1000.leetcode_502;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((i1, i2) -> profits[i2] - profits[i1]);
        int n = profits.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i1, i2) -> capital[i1] - capital[i2]);
        int cur = 0;
        int c = 0;
        while (c < k) {
            while (cur < n && capital[ids[cur]] <= w) {
                PQ.offer(ids[cur]);
                cur += 1;
            }
            if (PQ.isEmpty()) {
                break;
            }
            int pIdx = PQ.poll();
            w += profits[pIdx];
            c += 1;
        }
        return w;
    }
}
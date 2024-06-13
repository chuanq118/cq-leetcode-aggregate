package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_7;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int reverse(int x) {
        long xl = x;
        boolean isNegative = xl < 0;
        if (isNegative) {
            xl = -xl;
        }
        Deque<Long> Q = new LinkedList<>();
        long rate = 10;
        while (xl >= rate) {
            Q.offer(xl % rate);
            xl /= rate;
        }
        long rx = 0;
        while (!Q.isEmpty()) {
            int n = Q.size();
            long num = Q.poll();
            rx += (num * powOfTen(n));
        }
        rx += xl;
        rx = isNegative ? -rx : rx;
        if ((isNegative && rx < Integer.MIN_VALUE) || (!isNegative && rx > Integer.MAX_VALUE)) {
            return 0;
        }
        return (int)rx;
    }

    private long powOfTen(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

}
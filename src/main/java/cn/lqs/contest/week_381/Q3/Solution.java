package cn.lqs.contest.week_381.Q3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int[] counter = new int[26];
        for (char c : word.toCharArray()) {
            counter[c - 'a'] += 1;
        }
        Integer[] idx = new Integer[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (prev, next)-> counter[next] - counter[prev]);
        // 前 8 个 一次
        for (int i = 0; i < 8; i++) {
            ans += counter[idx[i]];
        }
        // 下一个 8 个 二次
        for (int i = 8; i < 16; i++) {
            ans += (counter[idx[i]] * 2);
        }
        // 三次
        for (int i = 16; i < 24; i++) {
            ans += (counter[idx[i]] * 3);
        }
        // 四次
        for (int i = 24; i < 26; i++) {
            ans += (counter[idx[i]] * 4);
        }
        return ans;
    }
}
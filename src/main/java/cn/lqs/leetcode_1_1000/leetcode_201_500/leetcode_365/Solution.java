package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_365;

import java.util.HashSet;

class Solution {

    int c1;
    int c2;
    int tc;
    HashSet<String> cache = new HashSet<>();

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        this.c1 = jug1Capacity;
        this.c2 = jug2Capacity;
        this.tc = targetCapacity;
        return dfs(0, 0);
    }

    private boolean dfs(int water1, int water2) {
        String key = water1 + "#" + water2;
        if (!cache.add(key)) {
            return false;
        }
        if (water1 == tc || water2 == tc || water2 + water1 == tc) {
            return true;
        }
        if (dfs(c1, water2) || dfs(water1, c2) || dfs(0, water2) || dfs(water1, 0)) {
            return true;
        }
        if (dfs(Math.max(water1 - (c2 - water2), 0), Math.min(water1 + water2, c2))) {
            return true;
        }
        if (dfs(Math.min(water1 + water2, c1), Math.max(water2 - (c1 - water1), 0))) {
            return true;
        }
        return false;
    }
}
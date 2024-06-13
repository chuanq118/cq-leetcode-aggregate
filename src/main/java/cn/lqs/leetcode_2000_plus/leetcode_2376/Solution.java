package cn.lqs.leetcode_2000_plus.leetcode_2376;

import java.util.HashMap;
import java.util.Objects;

class Solution {

    String ns;
    HashMap<String, Integer> cache;

    public int countSpecialNumbers(int n) {
        this.ns = String.valueOf(n);
        this.cache = new HashMap<>();
        return dfs(0, 0, true);
    }

    private int dfs(int i, int mask, boolean isLimit) {
        if (i == ns.length()) {
            return mask == 0 ? 0 : 1;
        }
        String key = i + "#" + mask + "#" + isLimit;
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        int res = 0;
        if (mask == 0) {
            res += dfs(i + 1, mask, false);
        }
        int up = isLimit ? ns.charAt(i) - '0' : 9;
        int low = mask == 0 ? 1 : 0;
        for (int k = low; k <= up; k++) {
            if ((mask & (1 << k)) == 0) {
                res += dfs(i + 1, mask | (1 << k), isLimit && k == up);
            }
        }
        this.cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().countSpecialNumbers(20);
        System.out.println("res = " + res);
    }
}
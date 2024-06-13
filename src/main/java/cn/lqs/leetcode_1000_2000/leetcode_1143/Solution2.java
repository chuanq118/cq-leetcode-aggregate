package cn.lqs.leetcode_1000_2000.leetcode_1143;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    String t1;
    String t2;
    Map<String, Integer> cache;

    public int longestCommonSubsequence(String text1, String text2) {
        this.t1 = text1;
        this.t2 = text2;
        this.cache = new HashMap<>();
        return dfs(text1.length() - 1, text2.length() - 1);
    }

    private int dfs(int i1, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        String key = i1 + "#" + i2;
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        int res = t1.charAt(i1) == t2.charAt(i2) ?
                dfs(i1 - 1, i2 - 1) + 1 : Math.max(dfs(i1 - 1, i2), dfs(i1, i2 - 1));
        this.cache.put(key, res);
        return res;
    }

}

package cn.lqs.leetcode_1_1000.leetcode_514;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    HashMap<Long, Integer> cache = new HashMap<>();
    ArrayList<ArrayList<Integer>> charMap = new ArrayList<>(26);
    String ring;
    String key;
    int rn;
    int kn;
    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        this.rn = ring.length();
        this.kn = key.length();
        for (int i = 0; i < 26; i++) {
            charMap.add(new ArrayList<>());
        }
        for (int i = 0; i < ring.length(); i++) {
            charMap.get(ring.charAt(i) - 'a').add(i);
        }
        return dfs(0, 0) + key.length();
    }

    private int dfs(int ri, int ki) {
        if (ki >= kn) {
            return 0;
        }
        long ck = ((long) ri << 32) | ki;
        if (cache.containsKey(ck)) {
            return cache.get(ck);
        }
        int res = Integer.MAX_VALUE;
        for (int idx : charMap.get(key.charAt(ki) - 'a')) {
            int dist = Math.abs(idx - ri);
            res = Math.min(dfs(idx, ki + 1) + Math.min(dist, rn - dist), res);
        }
        cache.put(ck, res);
        return res;
    }


}
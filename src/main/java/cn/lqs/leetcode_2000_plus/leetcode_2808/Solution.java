package cn.lqs.leetcode_2000_plus.leetcode_2808;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n * 2; i++) {
            int num = nums.get(i % n);
            if (!map.containsKey(num)) {
                map.put(num, new int[]{0, i});
                continue;
            }
            int[] inf = map.get(num);
            inf[0] = Math.max(inf[0], i - inf[1]);
            inf[1] = i;
        }
        int minT = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            minT = Math.min(entry.getValue()[0], minT);
        }
        return minT / 2;
    }
}
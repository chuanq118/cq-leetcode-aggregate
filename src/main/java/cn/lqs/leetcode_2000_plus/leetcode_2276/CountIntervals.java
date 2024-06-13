package cn.lqs.leetcode_2000_plus.leetcode_2276;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class CountIntervals {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    int cnt;

    public CountIntervals() {}

    public void add(int left, int right) {
        for (Map.Entry<Integer, Integer> entry = tMap.ceilingEntry(left); entry != null && right >= entry.getValue(); entry = tMap.ceilingEntry(left)) {
            left = Math.min(entry.getValue(), left);
            right = Math.max(entry.getKey(), right);
            cnt -= right - left + 1;
            tMap.remove(entry.getKey());
        }
        cnt += right - left + 1;
        tMap.put(right, left);
    }

    public int count() {
        return cnt;
    }

}
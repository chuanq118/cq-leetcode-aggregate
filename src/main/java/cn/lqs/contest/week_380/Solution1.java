package cn.lqs.contest.week_380;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution1 {
  public int maxFrequencyElements(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = -1;
    for (int num : nums) {
      int maxV = map.getOrDefault(num, 0) + 1;
      max = Math.max(maxV, max);
      map.put(num, maxV);
    }
    int ans = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
        ans += max;
      }
    }
    return ans;

  }
}

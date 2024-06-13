package cn.lqs.leetcode_2000_plus.leetcode_2182;

import java.util.Map;
import java.util.TreeMap;

class Solution {
  public String repeatLimitedString(String s, int repeatLimit) {
    TreeMap<Character, Integer> TM = new TreeMap<>((ch1, ch2) -> ch2 - ch1);
    for (char c : s.toCharArray()) {
      TM.put(c, TM.getOrDefault(c, 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
    while (true) {
      Map.Entry<Character, Integer> fEntry = TM.pollFirstEntry();
      if (fEntry != null) {
        for (int i = 1; i <= fEntry.getValue(); i++) {
          sb.append(fEntry.getKey());
          if (i < fEntry.getValue() && i % repeatLimit == 0) {
            if (TM.isEmpty()) {
              break;
            }
            Character padKey = TM.firstKey();
            sb.append(padKey);
            int leftTimes = TM.get(padKey) - 1;
            if (leftTimes == 0) {
              TM.remove(padKey);
            } else {
              TM.put(padKey, leftTimes);
            }
          }
        }
        continue;
      }
      break;
    }
    return sb.toString();
  }

    public static void main(String[] args) {
        new Solution().repeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy", 2);
    }
}
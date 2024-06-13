package cn.lqs.contest.week_380;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public List<Integer> beautifulIndices(String s, String a, String b, int k) {
    int al = a.length();
    int sl = s.length();
    int bl = b.length();
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i <= sl - al; i++) {
      boolean find = false;
      if (a.equals(s.substring(i, i+al))) {
        for (int j = Math.max(0, i-k); j <= (sl-bl) && j <= (i+k); j++) {
          if (b.equals(s.substring(j, j+bl))) {
            find = true;
            break;
          }
        }
      }
      if (find) {
        ans.add(i);
      }
    }
    return ans;
  }
}

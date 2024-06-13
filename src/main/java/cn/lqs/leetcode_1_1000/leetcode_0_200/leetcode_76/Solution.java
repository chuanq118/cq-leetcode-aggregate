package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int pr = -1;
        int[] ans = new int[]{-1, s.length()};
        while (l < s.length()) {
            while (l < s.length() && !tMap.containsKey(s.charAt(l))){
                l += 1;
            }
            r = Math.max(r, l);
            while (r < s.length()) {
                char rc = s.charAt(r);
                if (r > pr) {
                    sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);
                    pr = r;
                }
                if (sMap.size() >= tMap.size() && tMap.containsKey(rc)) {
                    boolean ok = true;
                    for (char tKey : tMap.keySet()) {
                        if (sMap.getOrDefault(tKey, 0) < tMap.get(tKey)) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        break;
                    }
                }
                r += 1;
            }
            if (r >= s.length()) {
                break;
            }
            if ((r - l + 1) < (ans[1] - ans[0])) {
                ans[0] = l;
                ans[1] = r;
            }
            sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
            l += 1;
        }
        if (ans[0] == -1) {
            return "";
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("bdab", "ab"));
    }
}
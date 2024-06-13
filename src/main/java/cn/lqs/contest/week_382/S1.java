package cn.lqs.contest.week_382;

public class S1 {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        char pre = s.charAt(0);
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != pre) {
                ans++;
                pre = s.charAt(i);
            }
        }
        return ans;
    }
}

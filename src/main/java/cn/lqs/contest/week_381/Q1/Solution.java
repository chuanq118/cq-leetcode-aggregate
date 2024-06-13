package cn.lqs.contest.week_381.Q1;

class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int n = word.length();
        if(n > 24) {
            ans += (n - 24) * 4;
            n = 24;
        }
        if (n > 16) {
            ans += (n - 16) * 3;
            n = 16;
        }
        if (n > 8) {
            ans += (n - 8) * 2;
            n = 8;
        }
        ans += n;
        return ans;
    }
}
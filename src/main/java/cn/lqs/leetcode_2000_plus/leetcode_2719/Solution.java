package cn.lqs.leetcode_2000_plus.leetcode_2719;

import java.util.HashMap;

class Solution {

    String maxNs;
    String minNs;
    int MinDigitSum;
    int MaxDigitSum;
    int MOD_VAL = 1000000007;
    HashMap<String, Long> cache;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        initMaxMinNs(num1, num2);
        MinDigitSum = min_sum;
        MaxDigitSum = max_sum;
        this.cache = new HashMap<>();
        long ans = dfs(0, true, false, true,0);
        System.out.println("ans = " + ans);
        System.out.println("ans/mod = " + ans % MOD_VAL);
        return (int) ans;
    }

    private void initMaxMinNs(String num1, String num2) {
        if (num1.length() != num2.length()){
            if (num1.length() > num2.length()) {
                maxNs = num1;
                minNs = num2;
            }else{
                maxNs = num2;
                minNs = num1;
            }
        }else {
            int diff = 0;
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) != num2.charAt(i)) {
                    diff = num1.charAt(i) - num2.charAt(i);
                    break;
                }
            }
            if (diff > 0) {
                maxNs = num1;
                minNs = num2;
            }else{
                maxNs = num2;
                minNs = num1;
            }
        }
    }

    private long dfs(int i, boolean isFir, boolean isLowLimit, boolean isUpLimit, int ds){
        if (i == maxNs.length()) {
            return (MinDigitSum <= ds && ds <= MaxDigitSum) ? 1 : 0;
        }
        String key = i + "#" + isFir + "#" + isLowLimit + "#" + isUpLimit + "#" + ds;
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        long res = 0;
        int up, low;
        int minus = maxNs.length() - minNs.length();
        if (i < minus){
            if (isFir) {
                res += dfs(i + 1, true, false, false, ds);
            }
            low = isFir ? 1 : 0;
            up = isUpLimit ? maxNs.charAt(i) - '0' : 9;
        }else{
            if (isFir){
                if (i > minus){
                    return 0;
                } else {
                    isLowLimit = true;
                }
            }
            low = isFir || isLowLimit ? minNs.charAt(i - minus) - '0' : 0;
            up = isUpLimit ? maxNs.charAt(i) - '0' : 9;
        }
        for (int k = low; k <= up; k++) {
            res += dfs(i + 1, false, isLowLimit && k == low, isUpLimit && k == up, ds + k);
        }
        res %= MOD_VAL;
        this.cache.put(key, res);
        return res;
    }

    private int digitSum(int x){
        int res = 0;
        while (x > 0){
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        StringBuilder prefix = new StringBuilder("1");
        for (int i = 0; i < 9; i++) {
            prefix.append("0");
        }
        System.out.println(prefix);
        // 2024441399
        // 1000000007
        // 883045899
        // 24441385

        System.out.println(2024441399 % 1000000007);
        // 4179205230
        // 7748704426
        int count = new Solution().count("4179205230", "7748704426", 8, 46);
    }
}
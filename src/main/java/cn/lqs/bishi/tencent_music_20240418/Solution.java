package cn.lqs.bishi.tencent_music_20240418;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param k int整型
     * @return int整型
     */
    public int maxLen (String s, int k) {
        // write code here
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int n1 = 0;
        for (char ch : chars) {
            if (ch == '1') {
                n1 += 1;
            }
        }
        if (k >= n1) {
            return 0;
        }
        if (k >= (n1 >> 1)) {
            return 1;
        }
        // dfs()
        return dfs(chars, 0, chars.length - 1, k);
    }

//    static HashMap<String, Integer> cache = new HashMap<>();

    private int dfs(char[] chars, int l, int r, int k){
        if(l > r){
            return Integer.MAX_VALUE;
        }

//        String key = l + "#" + r + "#" + k;
//        if (cache.containsKey(key)) {
//            return cache.get(key);
//        }

        int n1 = 0;
        for (int i = l; i <= r; i++) {
            if (chars[i] == '1') {
                n1 += 1;
            }
        }
        if(k >= n1){
//            cache.put(key, 0);
            return 0;
        }
        if (k >= (n1 >> 1)) {
//            cache.put(key, 1);
            return 1;
        }

        if(k <= 0){
            int p = l;
            int kRes = 0;
            while(p <= r){
                while(p <= r && chars[p] == '0'){
                    p += 1;
                }
                int ps = p;
                while(p <= r && chars[p] == '1'){
                    p += 1;
                }
                kRes = Math.max(p - ps, kRes);
            }
//            cache.put(key, kRes);
            return kRes;
        }
        int res = Integer.MAX_VALUE;
        for(int i = l; i <= r; i += 1){
            if(chars[i] == '1'){
                int ck = k - 1;
                for(int lk = 0; lk <= ck; lk += 1){
                    int minLS = dfs(chars, l, i - 1, lk);
                    int minRS = dfs(chars, i + 1, r, ck - lk);
                    res = Math.min(Math.max(minLS, minRS), res);
                }
            }
        }
//        cache.put(key, res);
        return res;
    }
}
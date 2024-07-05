class Solution {
    String text1;
    String text2;
    Map<String, Integer> cache;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.cache = new HashMap<>();
        return dfs(text1.length() - 1, text2.length() - 1);
    }

    // dfs()
    private int dfs(int i1, int i2){
        if(i1 < 0 || i2 < 0){
            return 0;
        }
        String key = i1 + "#" + i2;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        char ch1 = text1.charAt(i1);
        char ch2 = text2.charAt(i2);
        int res = 0;
        if(ch1 == ch2){
            res = dfs(i1 - 1, i2 - 1) + 1;
        }else{
            res = Math.max(dfs(i1 - 1, i2), dfs(i1, i2 - 1));
        }
        cache.put(key, res);
        return res;
    }
}
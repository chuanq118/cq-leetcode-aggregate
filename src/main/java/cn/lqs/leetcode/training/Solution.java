class Solution {
    String word1;
    String word2;
    Map<String, Integer> cache;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.cache = new HashMap<>();
        return dfs(0, 0);
    }

    private int dfs(int idx1, int idx2){
        if(idx1 == word1.length()){
            return word2.length() - idx2;
        }
        if(idx2 == word2.length()){
            return word1.length() - idx1;
        }
        String key = idx1 + "#" + idx2;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int res = 0;
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            res = dfs(idx1 + 1, idx2 + 1);
        }else{
            res = Math.min(Math.min(dfs(idx1 + 1, idx2), dfs(idx1 + 1, idx2 + 1)), dfs(idx1, idx2 + 1)) + 1;
        }
        cache.put(key, res);
        return res;
    }
}
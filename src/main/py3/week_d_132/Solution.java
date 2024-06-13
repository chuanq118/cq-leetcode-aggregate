class Solution {
    HashMap<String, Integer> mem;
    int n;
    int k;
    int[] nums;
    public int maximumLength(int[] nums, int k) {
        this.mem = new HashMap<>();
        this.n = nums.length;
        this.k = k;
        this.nums = nums;
        return dfs(-1, 0, 0);
    }

    private int dfs(int pn, int ci, int kc) {
        if (ci >= n || kc > k){
            return 0;
        }
        String key = pn + "-" + ci + "-" + kc;
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        int res = 0;
        if (pn == -1){
            res = Math.max(dfs(nums[ci], ci + 1, kc) + 1, dfs(pn, ci + 1, kc));
        }else if(nums[ci] == pn){
            res = dfs(pn, ci + 1, kc) + 1;
        }else{
            res = kc == k ? dfs(pn, ci + 1, kc)
                    : Math.max(dfs(nums[ci], ci + 1, kc + 1) + 1, dfs(pn, ci + 1, kc));
        }
        mem.put(key, res);
        return res;
    }
}
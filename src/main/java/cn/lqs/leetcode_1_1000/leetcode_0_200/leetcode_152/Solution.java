class Solution {
    int[] nums;
    HashMap<Integer, Integer> cache1;
    HashMap<Integer, Integer> cache2;
    public int maxProduct(int[] nums) {
        this.nums = nums;
        this.cache1 = new HashMap<>(1 << 8);
        this.cache2 = new HashMap<>(1 << 8);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i += 1){
            ans = Math.max(maxDfs(i), ans);
        }
        return ans;
    }

    private int maxDfs(int i){
        if(i == 0){
            return nums[0];
        }
        if(cache1.containsKey(i)){
            return cache1.get(i);
        }
        int res = nums[i] < 0 ? Math.max(minDfs(i - 1) * nums[i], nums[i]) : Math.max(maxDfs(i - 1) * nums[i], nums[i]);
        cache1.put(i, res);
        return res;
    }

    private int minDfs(int i){
        if(i == 0){
            return nums[0];
        }
        if(cache2.containsKey(i)){
            return cache2.get(i);
        }
        int res = nums[i] < 0 ? Math.min(maxDfs(i - 1) * nums[i], nums[i]) : Math.min(minDfs(i - 1) * nums[i], nums[i]);
        cache2.put(i, res);
        return res;
    }
}
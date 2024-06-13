package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_322;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> cache = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int left){
      if(left < 0) return -1;
      if(left == 0) return 0;
      if(cache.containsKey(left)) return cache.get(left);
      int mc = Integer.MAX_VALUE;
        for (int coin : coins) {
            int curLeft = left - coin;
            int res = dfs(coins, curLeft);
            if (res > -1) {
                mc = Math.min(res + 1, mc);
            }
        }
      mc = mc == Integer.MAX_VALUE ? -1 : mc;
      cache.put(left, mc);
      return mc;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
    }
}
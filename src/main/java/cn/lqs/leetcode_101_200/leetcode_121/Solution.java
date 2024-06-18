package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_121;

class Solution {
    int[] prices;
    public int maxProfit(int[] prices) {
      // dfs(i, 1) = dfs(i - 1, 1)  (dfs(i - 1, 0) - prices[i])
      // dfs(i, 0) = (dfs(i - 1, 1) + prices[i])  dfs(i - 1, 0)
      this.prices = prices;
      return dfs(prices.length - 1, false);
    }

    private int dfs(int day, boolean hasStock){
      if(day < 0){
        return hasStock ? Integer.MIN_VALUE : 0;
      }
      int res = 0;
      if(hasStock){
        res = Math.max(dfs(day - 1, true), dfs(day - 1, false) - prices[day]);
      }else{
        res = Math.max(dfs(day - 1, true) + prices[day], dfs(day - 1, false));
      }
      return res;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7,1,5,3,6,4});
    }
}
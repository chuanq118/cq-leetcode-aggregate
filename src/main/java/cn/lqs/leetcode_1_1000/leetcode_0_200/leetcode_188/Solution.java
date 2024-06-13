package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_188;

import java.util.HashMap;
import java.util.Map;

class Solution {

  Map<String, Long> cache;

  public int maxProfit(int k, int[] prices) {
    this.cache = new HashMap<>();
    long ans = Math.max(dfs(prices.length - 1, 1, k, prices), dfs(prices.length - 1, 0, k, prices));
    System.out.println("ans = " + ans);
    return (int) ans;
  }

  private long dfs(int dayI, int hasStock, int transactions, int[] prices) {
    if (transactions < 1) {
      return Integer.MIN_VALUE;
    }
    if (dayI < 0){
      return hasStock == 1 ? Integer.MIN_VALUE : 0;
    }
    String key = dayI + "#" + hasStock + "#" + transactions;
    if (this.cache.containsKey(key)) {
      return this.cache.get(key);
    }
    long profit = 0;
    if (hasStock == 1) {
      profit = Math.max(dfs(dayI - 1, 1, transactions, prices),
          dfs(dayI - 1, 0, transactions - 1, prices) - prices[dayI]);
    }else{
      profit = Math.max(dfs(dayI - 1, 0, transactions, prices),
          dfs(dayI - 1, 1, transactions, prices) + prices[dayI]);
    }
    this.cache.put(key, profit);
    return profit;
  }

  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE - 10);
    System.out.println((long) Integer.MIN_VALUE - 12);
  }

}
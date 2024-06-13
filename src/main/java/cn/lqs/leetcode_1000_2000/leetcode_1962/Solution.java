package cn.lqs.leetcode_1000_2000.leetcode_1962;

import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
      PriorityQueue<Integer> PQ = new PriorityQueue<>((prev, next)-> piles[next] - piles[prev]);
      int i = 0;
      for(; i < piles.length; i++){
        PQ.offer(i);
      }
      i = 0;
      while(i < k){
        int maxI = PQ.poll();
        piles[maxI] = piles[maxI] - piles[maxI] / 2;
        PQ.offer(maxI);
        i++;
      }
      int sum = 0;
      for(i = 0;i < piles.length; i++){
        sum += piles[i];
      }
      return sum;
    }

  public static void main(String[] args) {
    new Solution().minStoneSum(new int[]{4,3,6,7}, 3);
  }
}
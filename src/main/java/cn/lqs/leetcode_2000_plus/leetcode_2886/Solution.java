package cn.lqs.leetcode_2000_plus.leetcode_2886;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
      int n = maxHeights.size();
      long[] pre = new long[n];
      Stack<Long> STK = new Stack<>();
      STK.push((long)maxHeights.get(0));
      long lSum = maxHeights.get(0);
      pre[0] = lSum;
      for(int i = 1; i < n; i++){
        long cur = maxHeights.get(i);
        if (cur >= STK.peek()){
          lSum += cur;
          STK.push(cur);
        }else{
          while (!STK.isEmpty() && cur < STK.peek()){
            lSum -= STK.pop();
          }
          while(STK.size() <= i){
            lSum += cur;
            STK.push(cur);
          }
        }
        pre[i] = lSum;
      }

      STK.clear();
      long[] suf = new long[n];
      suf[n-1] = 0;
      long rSum = maxHeights.get(n-1);
      STK.push((long)maxHeights.get(n-1));
      for(int i = n - 2; i >= 0; i--){
        long cur = maxHeights.get(i);
        if(cur >= STK.peek()){
          STK.push(cur);
        }else{
          int popCount = 0;
          while (!STK.isEmpty() && cur < STK.peek()){
            rSum -= STK.pop();
            popCount++;
          }
          while(popCount > 0){
            rSum += cur;
            STK.push(cur);
            popCount--;
          }
          STK.push(cur);
        }
        suf[i] = rSum;
        rSum += cur;
      }

      long res = 0;
      for (int i = 0; i < n; i++) {
        res = Math.max(res, pre[i] + suf[i]);
      }
      return res;
    }

  public static void main(String[] args) {
    Solution s = new Solution();
    // 25
    long res = s.maximumSumOfHeights(Arrays.asList(6, 5, 3, 4, 6, 1, 2, 3, 2, 5));
    System.out.println("res = " + res);
  }

}
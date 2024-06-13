package cn.lqs.leetcode_1402;

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
      Arrays.sort(satisfaction);
      int divideIndex = -1;
      for(int i = 0; i < satisfaction.length; i++){
        if(satisfaction[i] >= 0){
          divideIndex = i;
          break;
        }
      }
      if(divideIndex == -1){
        return 0;
      }
      int plusSum = 0;
      for(int i = divideIndex; i < satisfaction.length; i++){
        plusSum += satisfaction[i];
      }
      int k = divideIndex - 1;
      int[] maxK = new int[2];
      boolean ok = false;
      for(; k > -1; k--){
        int toAdd = (divideIndex - k) * plusSum;
        int toReduce = 0;
        for(int j = k; j < divideIndex; j++){
          toReduce += satisfaction[j] * (j - k + 1);
        }
        toReduce = - toReduce;
        if(toReduce >= toAdd){
          k++;
          break;
        }
        ok = true;
        int addDiff = toAdd - toReduce;
        if(addDiff > maxK[0]){
          maxK[0] = addDiff;
          maxK[1] = k;
        }
      }
      // k = k == -1 ? 0 : k;
      if (ok){
        k = maxK[1];
      }else {
        k = k == -1 ? 0 : k;
      }
      int total = 0;
      for(int i = k; i < satisfaction.length; i++){
        total += satisfaction[i] * (i - k + 1);
      }
      return total;
    }

  public static void main(String[] args) {
    int[] satisfaction = new int[]{-5,-7,8,-2,1,3,9,5,-10,4,-5,-2,-1,-6};
    System.out.println(new Solution().maxSatisfaction(satisfaction));
  }
}
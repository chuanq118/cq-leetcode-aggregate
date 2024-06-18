package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
      Arrays.sort(citations);
      int h = 1;
      for(int i = citations.length - 1; i > -1; i--){
        if(citations[i] >= h){
          h++;
        }
        break;
      }
      return h - 1;
    }
}
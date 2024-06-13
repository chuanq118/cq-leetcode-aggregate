package cn.lqs.leetcode_2103;

class Solution {
    public int countPoints(String rings) {
      int[] colors = new int[10];
      char[] chs = rings.toCharArray();
      for(int k = 0; k < chs.length; k+=2){
        int i = 0;
        switch(chs[k]){
          case 'R':
              break;
          case 'G': i = 1; break;
          case 'B': i = 2; break;
        }
        if((colors[chs[k + 1]] & (1 << i)) == 0){
          colors[chs[k + 1]] |= (1 << i);
        }
      }
      int tar = (1) | (1 << 1) | (1 << 2);
      int count = 0;
      for(int color : colors){
        if(color == tar){
          count++;
        }
      }
      return count;
    }

  public static void main(String[] args) {
    new Solution().countPoints("B0B6G0R6R0R6G9");
  }
}
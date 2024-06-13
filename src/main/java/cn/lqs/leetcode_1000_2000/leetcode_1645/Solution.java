package cn.lqs.leetcode_1645;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
      long maxH = getMax(h, horizontalCuts);
      long maxV = getMax(w, verticalCuts);
      return (int)((maxH * maxV) % 1000000007);
    }

    private int getMax(int n, int[] arr){
      int maxH = 0;
      int pre = 0;
      for(int num : arr){
        int diff = num - pre;
        maxH = Math.max(maxH, diff);
        pre = num;
      }
      return Math.max(maxH, n - pre);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }
}
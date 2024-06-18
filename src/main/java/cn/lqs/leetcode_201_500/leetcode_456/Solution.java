package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_456;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean find132pattern(int[] nums) {
      int[] minArr = new int[nums.length];
      Deque<Integer> S = new ArrayDeque<>();
      for(int i = 0; i < nums.length; i++){
        int cur = nums[i];
        while(!S.isEmpty() && cur <= nums[S.peek()]){
          S.pop();
        }
        minArr[i] = S.isEmpty() ? -1 : S.peek();
        S.push(i);
      }
      S.clear();
      int[] maxArr = new int[nums.length];
      for(int i = 0; i < nums.length; i++){
        int cur = nums[i];
        while (!S.isEmpty() && cur >= nums[S.peek()]){
          S.pop();
        }
        maxArr[i] = S.isEmpty() ? -1 : S.peek();
        S.push(i);
      }
      for(int i = 0; i < nums.length; i++){
        if(minArr[i] != -1 && maxArr[i] != -1){
          if (minArr[i] < maxArr[i]) {
            return true;
          }
          // 进一步判断
          if (checkMore(nums, maxArr[i], nums[i])){
            return true;
          }
        }
      }
      return false;
    }

    private boolean checkMore(int[] nums, int endIdx, int tar){
      for (int i = endIdx - 1; i > -1; i--) {
        if (nums[i] < tar) {
          return true;
        }
      }
      return false;
    }

  public static void main(String[] args) {
    new Solution().find132pattern(new int[]{3,5,0,3,4});
  }
}
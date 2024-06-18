package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_496;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      HashMap<Integer, Integer> map = new HashMap<>(nums2.length);
      Stack<Integer> STK = new Stack<>();
      for(int i = nums2.length - 1; i > -1; i--){
        int cur = nums2[i];
        while (!STK.isEmpty() && cur > STK.peek()){
          STK.pop();
        }
        map.put(cur, STK.isEmpty() ? -1 : STK.peek());
        STK.push(cur);
      }
      int[] ans = new int[nums1.length];
      for(int i = 0; i < nums1.length; i++){
        ans[i] = map.get(nums1[i]);
      }
      return ans;
    }
}
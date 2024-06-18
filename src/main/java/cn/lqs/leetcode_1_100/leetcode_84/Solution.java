package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_84;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> dq = new LinkedList<>();
    int ans = heights[0];
    dq.push(0);
    for (int i = 1; i < heights.length; i++) {
      ans = Math.max(ans, heights[i]);
      if (heights[i] > heights[dq.peek()]) {
        dq.push(i);
        int nextIdx = -1;
        Iterator<Integer> iter = dq.iterator();
        while (iter.hasNext()) {
          int idx = iter.next();
          if (nextIdx != -1){
            ans = Math.max(heights[nextIdx] * (i - idx), ans);
          }
          nextIdx = idx;
        }
        ans = Math.max(heights[nextIdx] * (i + 1), ans);
      }else{
        while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
          ans = Math.max(heights[i] * (i - dq.peek() + 1), ans);
          dq.poll();
        }
        dq.push(i);
        int nextIdx = -1;
        Iterator<Integer> iter = dq.iterator();
        while (iter.hasNext()) {
          int idx = iter.next();
          if (nextIdx != -1){
            ans = Math.max(heights[nextIdx] * (i - idx), ans);
          }
          nextIdx = idx;
        }
        ans = Math.max(heights[nextIdx] * (i + 1), ans);
      }
    }
    int nextIdx = -1;
    while (!dq.isEmpty()) {
      if (nextIdx != -1) {
        ans = Math.max((heights.length - dq.peek() - 1) * heights[nextIdx], ans);
      }
      nextIdx = dq.poll();
    }
    return Math.max(ans, heights[nextIdx] * heights.length);
  }

  public static void main(String[] args) {
    new Solution().largestRectangleArea(new int[]{3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3});
    Deque<Integer> dq = new LinkedList<>();
    dq.push(1);
    dq.push(2);
    dq.push(3);
    Iterator<Integer> iter = dq.iterator();
    while (iter.hasNext()) {
      int idx = iter.next();
      System.out.println(idx);
    }
    // System.out.println(dq.peekLast());
    // System.out.println(dq.peek());
    // System.out.println(dq.poll());
    // System.out.println(dq.pollFirst());
  }

}
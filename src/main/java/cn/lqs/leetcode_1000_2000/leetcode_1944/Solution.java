package cn.lqs.leetcode_1000_2000.leetcode_1944;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    // 在向前遍历的过程中,维持一个递减的单调栈
    // 如果在单调栈中出现元素 current 需要弹出的情况
    // 那么其一定遇到了一个大于其的数字 next
    // 将 current 视野 + 1 表示其能够看到这个 next
    // 其前面的人 prev 能看到的视野 + 1
    // 表示 prev 能够看到 current
    // 最后对栈中的存在元素 +1 表示对最后元素的视野
    public int[] canSeePersonsCount(int[] heights) {
      int[] ans = new int[heights.length];
      Stack<Integer> STK = new Stack<>();
      for(int i = 0; i < heights.length; i++){
        while(!STK.isEmpty() && heights[STK.peek()] < heights[i]){
          int idx = STK.pop();
          if (!STK.isEmpty()) {
            ans[STK.peek()] += 1;
          }
          ans[idx] += 1;
        }
        STK.push(i);
      }
      STK.pop();
      while(!STK.isEmpty()){
        ans[STK.pop()] += 1;
      }
      return ans;
    }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().canSeePersonsCount(new int[]{11,19,12,15,14,18,7,1,8,9})));
  }
}
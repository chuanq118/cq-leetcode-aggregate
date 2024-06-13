package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int n = gas.length;
      int startPos = 0;
      while(startPos < n){
        int pos = startPos;
        int left = gas[pos] - cost[pos];
        while(left >= 0){
          pos = (pos + 1) % n;
          if(pos == startPos){
            break;
          }
          left += (gas[pos] - cost[pos]);
        }
        if(pos == startPos && left >= 0){
          break;
        }
        if (pos < startPos){
          return -1;
        }
        startPos = pos + 1;
      }
      return startPos < n ? startPos : -1;
    }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
  }
}
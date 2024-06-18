package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_300;

class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] cache = new int[nums.length];
      int maxAns = Integer.MIN_VALUE;
      for (int i = nums.length-1; i > -1; i--) {
        maxAns = Math.max(maxAns, dfs(nums, i, cache));
      }
      return maxAns;
    }

    private int dfs(int[] nums, int k, int[] cache){
      if(cache[k] > 0) return cache[k];
      int maxCo = Integer.MIN_VALUE;
      for(int i = 0; i < k; i++){
        if(nums[i] < nums[k]){
          maxCo = Math.max(dfs(nums, i, cache), maxCo);
        }
      }
      int ans = maxCo == Integer.MIN_VALUE ? 1 : maxCo + 1;
      cache[k] = ans;
      return ans;
    }

  public static void main(String[] args) {
    int val = new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    System.out.println("val = " + val);
  }
}
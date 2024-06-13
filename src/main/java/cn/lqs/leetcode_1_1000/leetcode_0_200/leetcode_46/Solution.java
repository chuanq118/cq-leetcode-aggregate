package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] flags;
    List<List<Integer>> ans;
    List<Integer> collector;
    public List<List<Integer>> permute(int[] nums) {
      this.flags = new boolean[nums.length];
      this.ans = new ArrayList<>();
      this.collector = new ArrayList<>(nums.length);
      dfs(nums);
      return ans;
    }

    private void dfs(int[] nums){
      if(collector.size() == nums.length){
        List<Integer> copied = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
          copied.add(collector.get(i));
        }
        this.ans.add(copied);
        return;
      }
      for(int i = 0; i < nums.length; i++){
        if(!this.flags[i]){
          this.flags[i] = true;
          collector.add(nums[i]);
          dfs(nums);
          collector.remove(collector.size() - 1);
          this.flags[i] = false;
        }
      }
    }

    public static void main(String[] args) {
        new Solution().permute(new int[]{1,2,3});

    }
}
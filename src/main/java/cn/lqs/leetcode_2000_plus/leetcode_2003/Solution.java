package cn.lqs.leetcode_2003;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
      List<List<Integer>> children = new ArrayList<>(parents.length);
      for(int i = 0; i < parents.length; i++){
        children.add(new ArrayList<>());
      }
      for(int i = 0; i < parents.length; i++){
        if(parents[i] != -1){
          children.get(parents[i]).add(i);
        }
      }
      int[] ans = new int[parents.length];
      List<Set<Integer>> genes = new ArrayList<>();
      for(int i = 0; i < parents.length; i++){
        genes.add(new HashSet<>());
      }
      dfs(0, genes, children, ans, nums);
      return ans;
    }

    private void dfs(int nodeIndex, List<Set<Integer>> genes, List<List<Integer>> children, int[] ans, int[] nums){
      if(ans[nodeIndex] == 0){
        for(int childIndex : children.get(nodeIndex)){
          if(ans[childIndex] == 0){
            dfs(childIndex, genes, children, ans, nums);
          }
          genes.get(nodeIndex).addAll(genes.get(childIndex));
        }
        genes.get(nodeIndex).add(nums[nodeIndex]);
        Set<Integer> set = genes.get(nodeIndex);
        for(int i = 1; i <= 100000; i++){
          if(!set.contains(i)){
            ans[nodeIndex] = i;
            break;
          }
        }
      }
    }

  public static void main(String[] args) {
    int[] parents = new int[]{-1,0,1,0,3,3};
    int[] nums = new int[]{5,4,6,2,1,3};
    int[] ans = new Solution().smallestMissingValueSubtree(parents, nums);
    for(int i : ans){
      System.out.println(i);
    }
  }
}
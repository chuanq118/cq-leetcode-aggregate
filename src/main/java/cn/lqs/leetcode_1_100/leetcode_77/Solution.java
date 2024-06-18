package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> ans = new LinkedList<>();
  ArrayList<Integer> list = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    dfs(1, n, k);
    return ans;
  }

  private void dfs(int j, int n, int k){
    if (list.size() >= k){
      ans.add(new ArrayList<>(list));
      return;
    }
    for(int i = j; i <= n; i++){
      list.add(i);
      dfs(i+1, n, k);
      list.remove(list.size()-1);
    }
  }
}
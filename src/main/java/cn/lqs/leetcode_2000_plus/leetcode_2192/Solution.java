package cn.lqs.leetcode_2000_plus.leetcode_2192;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
      List<List<Integer>> ans = new ArrayList<>(n);
      List<List<Integer>> adj = new ArrayList<>(n);
      for(int i = 0; i < n; i++){
        ans.add(new ArrayList<>());
        adj.add(new ArrayList<>());
      }
      for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
      }
      for(int i = 0; i < n; i++){
        boolean[] visited = new boolean[n];
        dfs(adj, ans, i, i, visited);
      }
      return ans;
    }

    private void dfs(List<List<Integer>> adj,
                     List<List<Integer>> ans,
                     int pi, int ci, boolean[] visited){
      visited[ci] = true;
      for(int ni : adj.get(ci)){
        if(!visited[ni]){
          ans.get(ni).add(pi);
          dfs(adj, ans, pi, ni, visited);
        }
      }
    }
}
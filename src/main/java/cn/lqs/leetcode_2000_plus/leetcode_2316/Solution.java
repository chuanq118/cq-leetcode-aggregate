package cn.lqs.leetcode_2316;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public long countPairs(int n, int[][] edges) {
      ArrayList<ArrayList<Integer>> adjs = new ArrayList<>();
      for(int i = 0; i < n; i++){
        adjs.add(new ArrayList<>());
      }
      for(int[] edge : edges){
        adjs.get(edge[0]).add(edge[1]);
        adjs.get(edge[1]).add(edge[0]);
      }
      boolean[] visited = new boolean[n];
      Queue<Integer> Q = new LinkedList<>();
      ArrayList<Integer> counter = new ArrayList<>();
      for(int i = 0; i < n; i++){
        if(!visited[i]){
          counter.add(bfs(adjs, visited, Q, i));
        }
      }
      int total = 0;
      for(int i = 0; i < counter.size(); i++){
        for(int j = i + 1; j < counter.size(); j++){
          total += counter.get(i) * counter.get(j);
        }
      }
      return total;
    }

    private int bfs(ArrayList<ArrayList<Integer>> adjs, boolean[] visited, Queue<Integer> Q, int i){
      int count = 0;
      Q.offer(i);
      while(!Q.isEmpty()){
        int node = Q.poll();
        if(!visited[node]){
          visited[node] = true;
          count++;
          for(int adj : adjs.get(node)){
              Q.offer(adj);
          }
        }
      }
      return count;
    }

  public static void main(String[] args) {
    int[][] edges = new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
    System.out.println(new Solution().countPairs(7, edges));
  }
}
package cn.lqs.leetcode_2477;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
      int n = roads.length + 1;
      int[] passengers = new int[n];
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
        passengers[i] = 1;
      }
      for(int[] road : roads){
        adj.get(road[0]).add(road[1]);
        adj.get(road[1]).add(road[0]);
      }
      int liters = 0;
      if(seats > 1){
        boolean ok = false;
        while(!ok){
          ok = true;
          for(int i = 1; i < n; i++){
            List<Integer> neighbors = adj.get(i);
            if(neighbors.size() == 1){
              int neighbor = neighbors.get(0);
              int totalPassengers = passengers[neighbor] + passengers[i];
              if(neighbor != 0 && totalPassengers <= seats){
                ok = false;
                passengers[neighbor] = totalPassengers;
                liters++;
                neighbors.remove((Integer) neighbor);
                adj.get(neighbor).remove((Integer) i);
              }
            }
          }
        }
      }
      List<Integer> rings = new ArrayList<>();
      boolean[] visited = new boolean[n];
      Queue<Integer> Q = new LinkedList<>();
      Q.offer(0);
      visited[0] = true;
      while(!Q.isEmpty()){
        int len = Q.size();
        rings.add(len);
        for(int i = 0; i < len; i++){
          int cityNum = Q.poll();
          for (int adjCity : adj.get(cityNum)){
            if(!visited[adjCity]){
              Q.offer(adjCity);
              visited[adjCity] = true;
            }
          }
        }
      }
      for(int i = 1; i < rings.size(); i++){
        liters += (rings.get(i) * i);
      }
      return liters;
    }

  public static void main(String[] args) {
    int[][] array = {
            {0, 1},
            {2, 1},
            {3, 2},
            {4, 2},
            {4, 5},
            {6, 0},
            {5, 7},
            {8, 4},
            {9, 2}
    };
    new Solution().minimumFuelCost(array, 2);
  }

}
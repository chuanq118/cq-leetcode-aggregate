package cn.lqs.leetcode_1000_2000.leetcode_1631;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
      int m = heights.length;
      int n = heights[0].length;
      TreeMap<Integer, List<int[]>> weights = new TreeMap<>(Comparator.comparingInt(pe -> pe));
      // compute the row weights
      for(int i = 0; i < m; i++){
        for(int j = 0; j < (n-1); j++){
          int weight = Math.abs(heights[i][j] - heights[i][j+1]);
          if (!weights.containsKey(weight)) {
            weights.put(weight, new ArrayList<>());
          }
          // use 0 represent connect with right element
          weights.get(weight).add(new int[]{i, j, 0});
        }
      }
      // compute the col weights
      for(int i = 0; i < (m-1); i++){
        for(int j = 0; j < n; j++){
          int weight = Math.abs(heights[i][j] - heights[i+1][j]);
          if (!weights.containsKey(weight)) {
            weights.put(weight, new ArrayList<>());
          }
          // use 1 represent connect with bottom element
          weights.get(weight).add(new int[]{i, j, 1});
        }
      }
      Map.Entry<Integer, List<int[]>> entry = null;
      Union union = new Union(m * n);
      int minCost = -1;
      int fp = 0, lp = m * n - 1;
      while (((entry = weights.pollFirstEntry()) != null) && minCost == -1) {
        for (int[] point : entry.getValue()) {
          int x = point[0] * n + point[1];
          int y = point[2] == 0 ? point[0] * n + point[1] + 1 : (point[0] + 1) * n + point[1];
          union.union(x, y);
          if (union.isConnect(fp, lp)){
            minCost = entry.getKey();
            break;
          }
        }
      }
      return minCost == -1 ? 0 : minCost;
    }

    static class Union {

      private final int[] parent;

      Union(int total){
        this.parent = new int[total];
        for (int i = 0; i < this.parent.length; i++) {
          this.parent[i] = i;
        }
      }

      private int findParent(int i) {
        while (i != this.parent[i]){
          this.parent[i] = this.parent[this.parent[i]];
          i = this.parent[i];
        }
        return i;
      }

      void union(int x, int y) {
        int xp = findParent(x);
        int yp = findParent(y);
        if (xp == yp){
          return;
        }
        this.parent[xp] = this.parent[yp];
      }

      boolean isConnect(int x, int y) {
        return findParent(x) == findParent(y);
      }

    }
}
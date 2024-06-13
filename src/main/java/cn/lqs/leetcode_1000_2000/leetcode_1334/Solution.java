package cn.lqs.leetcode_1334;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] mat = new int[n][n];
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          mat[i][j] = i == j ? 0 : Integer.MAX_VALUE;
        }
      }
      for(int[] edge : edges){
        mat[edge[0]][edge[1]] = Math.min(mat[edge[0]][edge[1]], edge[2]);
        mat[edge[1]][edge[0]] = Math.min(mat[edge[1]][edge[0]], edge[2]);
      }
      floyd(n, mat);
      int minCityNum = Integer.MAX_VALUE;
      int point = 0;
      for(int i = 0; i < n; i++){
        int counter = 0;
        for(int j = 0; j < n; j++){
          if(i == j) continue;
          if(mat[i][j] <= distanceThreshold){
            counter++;
          }
        }
        if(counter <= minCityNum){
          minCityNum = counter;
          point = i;
        }
      }
      return point;
    }

    private void floyd(int n, int[][] mat){
      for(int p = 0; p < n; p++){
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            if (mat[i][p] == Integer.MAX_VALUE || mat[p][j] == Integer.MAX_VALUE){
              continue;
            }
            mat[i][j] = Math.min(mat[i][j], mat[i][p] + mat[p][j]);
          }
        }
      }
    }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.findTheCity(5, new int[][]{
            {0, 1, 2},
            {0, 4, 8},
            {1, 2, 3},
            {1, 4, 2},
            {2, 3, 1},
            {3, 4, 1}
    }, 2));
  }
}
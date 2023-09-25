package cn.lqs.leetcode_2596;

class Solution {

    private int n = 0;
    private final int[][] dirs = new int[][]{
      {-2, 1}, {-2, -1}, {2, -1}, {2, 1},
      {-1, -2}, {1, -2}, {1, 2}, {-1, 2}
    };

    public boolean checkValidGrid(int[][] grid) {
      if(grid[0][0] != 0){
        return false;
      }
      n = grid.length;
      int[] currentPoint = new int[]{0, 0};
      for(int step = 1; step < n * n; step++){
        if(!tryMove(grid, currentPoint, step)){
          return false;
        }
      }
      return true;
    }

    private boolean tryMove(int[][] grid, int[] currentPoint, int nextIndex){
      for(int[] dir : dirs){
        int nextX = currentPoint[0] + dir[0];
        if(nextX < 0 || nextX >= n){
          continue;
        }
        int nextY = currentPoint[1] + dir[1];
        if(nextY < 0 || nextY >= n){
          continue;
        }
        if(grid[nextX][nextY] == nextIndex){
          currentPoint[0] = nextX;
          currentPoint[1] = nextY;
          return true;
        }
      }
      return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };
        System.out.println(solution.checkValidGrid(grid));
    }
}
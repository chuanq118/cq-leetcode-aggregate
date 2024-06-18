package cn.lqs.leetcode_909;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private ArrayList<int[]> pointIndex = null;
    private boolean arrivated = false;
    private boolean markUnarrivable = false;
    private int step = 0;
    public int snakesAndLadders(int[][] board) {
      int n = board.length;
      int end = n * n;
      HashSet<Integer> points = new HashSet<>();
      this.pointIndex = new ArrayList<>(n * n + 1);
      this.pointIndex.add(new int[0]);
      for(int i = 1; i <= n * n; i++){
        int left  = i % n;
        int div = i / n;
        int row = n - div - (left == 0 ? 0 : 1);
        int col = (n - row - 1) % 2 == 0 ? (left == 0 ? n - 1 : left - 1) : (left == 0 ? left : n - left);
        this.pointIndex.add(new int[]{row, col});
      }
      points.add(1);
      while(!markUnarrivable && !this.arrivated){
        System.out.println(points);
        points = getNextPoints(points, board, end);
      }
      return markUnarrivable ? -1 : this.step;
    }

    private HashSet<Integer> getNextPoints(HashSet<Integer> prePoints, int[][] board, int end){
      this.step++;
      HashSet<Integer> nextPoints = new HashSet<>();
      for(int point : prePoints){
        for(int i = 1; i <= 6; i++){
          nextPoints.add(Math.min(point + i, end));
        }
      }
      ArrayList<Integer> toAddPoints = new ArrayList<>();
      ArrayList<Integer> toRemovePoints = new ArrayList<>();
      for(int point : nextPoints){
        int[] boardIndex = this.pointIndex.get(point);
        int dest = board[boardIndex[0]][boardIndex[1]];
        if(dest != -1){
          toAddPoints.add(dest);
          toRemovePoints.add(point);
        }
      }
      // 先移除原点
      if(toRemovePoints.size() > 0){
        nextPoints.removeAll(toRemovePoints);
      }
      // 添加传送后的点
      if(toAddPoints.size() > 0){
        nextPoints.addAll(toAddPoints);
      }
      // 判断是否已经能够达到终点坐标
      if(nextPoints.contains(end)){
        this.arrivated = true;
      }
      if (prePoints.size() == nextPoints.size()) {
        boolean allSame = true;
        for (Integer prePoint : prePoints) {
          if (!nextPoints.contains(prePoint)) {
            allSame = false;
            break;
          }
        }
        if (allSame){
          this.markUnarrivable = true;
        }
      }
      return nextPoints;
    }

  public static void main(String[] args) {
    // [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[1,1,1,-1,13,-1],[1,1,1,1,1,8],[-1,8,8,8,8,8]]
    int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{1,1,1,-1,13,-1},{1,1,1,1,1,8},{-1,8,8,8,8,8}};
    System.out.println(new Solution().snakesAndLadders(board));
  }
}
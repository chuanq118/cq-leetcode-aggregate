package cn.lqs.leetcode_994;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[][] directions = new int[][]{
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private int globalM = 0;
    private int globalN = 0;

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        globalM = m;
        globalN = n;
        int maxRotMinute = 0;
        boolean[][] flag = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2 && !flag[i][j]){
                    maxRotMinute = Math.max(rot(i, j, grid, flag), maxRotMinute);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return maxRotMinute;
    }

    private int rot(int sm, int sn, int[][] grid, boolean[][] flag){
        Queue<int[]> Q = new LinkedList<int[]>();
        int minutes = -1;
        flag[sm][sn] = true;
        Q.offer(new int[]{sm, sn});
        while(!Q.isEmpty()){
            int batchSize = Q.size();
            for(int k = 0; k < batchSize; k++){
                int[] prePoint = Q.poll();
                for(int i = 0; i < 4; i++){
                    int[] point = new int[]{prePoint[0] + directions[i][0], prePoint[1] + directions[i][1]};
                    if(!isValidPoint(point)){
                        continue;
                    }
                    if(grid[point[0]][point[1]] == 1 && !flag[point[0]][point[1]]){
                        Q.offer(point);
                        grid[point[0]][point[1]] = 2;
                        flag[point[0]][point[1]] = true;
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }

    private boolean isValidPoint(int[] point){
        if(point[0] < 0){
            return false;
        }
        if(point[0] >= globalM){
            return false;
        }
        if(point[1] < 0){
            return false;
        }
        if(point[1] >= globalN){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(solution.orangesRotting(grid));
    }
}
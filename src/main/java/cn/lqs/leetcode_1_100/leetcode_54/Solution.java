package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] blocked = new boolean[m][n];
        int[] point = new int[]{0, 0};
        List<Integer> list = new ArrayList<>();
        int dirNum = 0;
        while (!blocked[point[0]][point[1]]) {
            blocked[point[0]][point[1]] = true;
            list.add(matrix[point[0]][point[1]]);
            int next_point_m = point[0] + dirs[dirNum][0];
            int next_point_n = point[1] + dirs[dirNum][1];
            // 判断是否越界 | 已遍历点
            if (next_point_m >= m || next_point_n >= n || next_point_m < 0 || next_point_n < 0 || blocked[next_point_m][next_point_n]) {
                // 转向
                dirNum = (dirNum + 1) % 4;
                next_point_m = point[0] + dirs[dirNum][0];
                next_point_n = point[1] + dirs[dirNum][1];
            }
            point[0] = next_point_m;
            point[1] = next_point_n;
        }
        return list;
    }

    public static void main(String[] args) {
      int[][] myArray = {
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}
      };
      new Solution().spiralOrder(myArray);
    }
}
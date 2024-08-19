package bishi.dj_0818.q1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {


    /* Write Code Here */
    public int numberOfPatrolBlocks(int[][] block) {
        int[] pos = new int[]{0, 0};
        int way = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = block.length;
        int n = block[0].length;
        boolean[][][] visited = new boolean[m][n][4];
        int ans = 0;
        while (!visited[pos[0]][pos[1]][way]) {
            // System.out.println("way=" + way);
            visited[pos[0]][pos[1]][way] = true;
            int nx = pos[0] + dirs[way][0];
            int ny = pos[1] + dirs[way][1];
            int changeTimes = 0;
            while (nx < 0 || ny < 0 || nx >= block.length || ny >= block[0].length || block[nx][ny] == 1) {
                changeTimes += 1;
                if (changeTimes > 3) {
                    break;
                }
                way = (way + 1) % 4;
                nx = pos[0] + dirs[way][0];
                ny = pos[1] + dirs[way][1];
            }
            if (changeTimes > 3 ) {
                break;
            }
            pos[0] = nx;
            pos[1] = ny;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j][0] || visited[i][j][1] || visited[i][j][2] || visited[i][j][3]) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int block_rows = 0;
        int block_cols = 0;
        block_rows = in.nextInt();
        block_cols = in.nextInt();
        
        int[][] block = new int[block_rows][block_cols];
        for(int block_i=0; block_i<block_rows; block_i++) {
            for(int block_j=0; block_j<block_cols; block_j++) {
                block[block_i][block_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }


        res = new Solution().numberOfPatrolBlocks(block);
        System.out.println(String.valueOf(res));    

    }
}

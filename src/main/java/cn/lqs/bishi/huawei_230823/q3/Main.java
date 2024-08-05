package cn.lqs.bishi.huawei_230823.q3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int[][] mat = new int[m][n];
        int[][] dist = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                mat[x][y] = in.nextInt();
                dist[x][y] = Integer.MAX_VALUE;
            }
        }
        in.close();

        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{j, k});
        dist[j][k] = 0;
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for(int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && mat[nx][ny] > 0) {
                    if(dist[cur[0]][cur[1]] + mat[cur[0]][cur[1]] < dist[nx][ny]){
                        dist[nx][ny] = dist[cur[0]][cur[1]] + mat[cur[0]][cur[1]];
                        dq.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int ans = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (mat[x][y] > 0) {
                    if (dist[x][y] == Integer.MAX_VALUE){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[x][y]);
                }
            }
        }
        System.out.println(ans);

    }
}

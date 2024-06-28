package cn.lqs.bishi.huawei_230823.q3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int[][] matrix = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                matrix[x][y] = in.nextInt();
            }
        }
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int timestamp = 0;
        Deque<int[]> que = new LinkedList<>();
        matrix[j][k] = 0;
        for(int d = 0; d < 4; d++) {
            int nx = j + dirs[d][0];
            int ny = k + dirs[d][1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > 0) {
                que.offer(new int[]{nx, ny, timestamp + matrix[j][k]});
            }
        }
        while (!que.isEmpty()) {
            timestamp += 1;
            int len = que.size();
            for (int i = 0; i < len; i++) {
                int[] cur = que.poll();
                if (matrix[cur[0]][cur[1]] == 0) {
                    continue;
                }
                if (cur[2] > timestamp) {
                    que.offer(cur);
                    continue;
                }
                matrix[cur[0]][cur[1]] = 0;
                for(int d = 0; d < 4; d++) {
                    int nx = cur[0] + dirs[d][0];
                    int ny = cur[1] + dirs[d][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > 0) {
                        que.offer(new int[]{nx, ny, timestamp + matrix[cur[0]][cur[1]]});
                    }
                }
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] > 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(timestamp);
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int j = in.nextInt();
//        int k = in.nextInt();
//        int[][] matrix = new int[m][n];
//        boolean[][] visited = new boolean[m][n];
//        int[][] costMatrix = new int[m][n];
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                matrix[x][y] = in.nextInt();
//                costMatrix[x][y] = -1;
//            }
//        }
//        costMatrix[j][k] = 0;
//        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Deque<int[]> que = new LinkedList<>();
//        que.offerLast(new int[]{j, k});
//        visited[j][k] = true;
//        while (!que.isEmpty()) {
//            int curN = que.size();
//            for (int i = 0; i < curN; i++) {
//                int[] tower = que.pollFirst();
//                for (int l = 0; l < 4; l++) {
//                    int nx = tower[0] + dirs[l][0];
//                    int ny = tower[1] + dirs[l][1];
//                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > 0) {
//                        que.offerLast(new int[]{nx, ny});
//                        visited[nx][ny] = true;
//                    }
//                }
//            }
//        }
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                if (matrix[x][y] > 0) {
//                    if (!visited[x][y]) {
//                        System.out.println("-1");
//                        return;
//                    }
//                }
//            }
//        }
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                visited[x][y] = false;
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                if (!visited[x][y] && costMatrix[x][y] > - 1) {
//                    visited[x][y] = true;
//                    improveCostMatrix(costMatrix, matrix, x, y);
//                }
//            }
//        }
//    }

//    private static void improveCostMatrix(int[][] costMatrix, int[][] towerMatrix, int sx, int sy) {
//        Queue<int[]> que = new LinkedList<>();
//        int m = towerMatrix.length;
//        int n = towerMatrix[0].length;
//        boolean[][] visited = new boolean[m][n];
//
//        int timestamp = costMatrix[sx][sy];
//        visited[sx][sy] = true;
//        que.offer(new int[]{sx, sy, costMatrix[sx][sy]});
//        while (!que.isEmpty()) {
//            int ne = que.size();
//
//        }
//    }

}

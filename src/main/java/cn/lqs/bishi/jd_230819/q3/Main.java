package cn.lqs.bishi.jd_230819.q3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n == 1 && m == 1) {
            System.out.println(0);
            return;
        }
        in.nextLine();
        char[][] mat = new char[n][m];
        int[][] minStepMat = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < line.length(); j++) {
                mat[i][j] = line.charAt(j);
            }
        }
//        for(int i = 1; i < mat.length; i++) {
//            if(mat[i][0] == '*'){
//                minStepMat[i][0] = Integer.MAX_VALUE;
//                continue;
//            }
//            minStepMat[i][0] = minStepMat[i - 1][0];
//        }
//        for(int j = 1; j < mat[0].length; j++) {
//            if(mat[0][j] == '*'){
//                minStepMat[0][j] = Integer.MAX_VALUE;
//                continue;
//            }
//            minStepMat[0][j] = minStepMat[0][j - 1];
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if (mat[i][j] == '*') {
//                    minStepMat[i][j] = Integer.MAX_VALUE;
//                    continue;
//                }
//            }
//        }
    }

    private static long dfs(int x, int y, char[][] mat) {
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] == '*') {
            return Integer.MAX_VALUE;
        }
        for(int px = x - 1; px <= x + 1; px++) {

        }
        return 0;
    }
}

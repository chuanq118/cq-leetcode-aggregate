package cn.lqs.bishi.jd_230819.q3;

import java.util.*;

/**
 * 当前解法: 超时
 */
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
        Map<String, Long> cache = new HashMap<>();
        System.out.println(dfs(n - 1, m - 1, mat, cache));
    }

    private static long dfs(int x, int y, char[][] mat, Map<String, Long> cache) {
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] == '*') {
            return Integer.MAX_VALUE;
        }
        String key = x + "," + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        long res = Integer.MAX_VALUE;
        for(int px = x - 1; px >= 0; px -= 1) {
            long pVal = dfs(px, y, mat, cache);
            if (pVal == Integer.MAX_VALUE) {
                break;
            }
            res = Math.min(pVal + 1, res);
        }
        for(int py = y - 1; py >= 0; py -= 1) {
            long pVal = dfs(x, py, mat, cache);
            if (pVal == Integer.MAX_VALUE) {
                break;
            }
            res = Math.min(pVal + 1, res);
        }
        for(int px = x - 1, py = y - 1; px >= 0 && py >= 0; px -= 1, py -= 1) {
            long pVal = dfs(px, py, mat, cache);
            if (pVal == Integer.MAX_VALUE) {
                break;
            }
            res = Math.min(pVal + 1, res);
        }
        cache.put(key, res);
        return res;
    }
}

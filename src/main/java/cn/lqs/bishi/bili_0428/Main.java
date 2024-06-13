package cn.lqs.bishi.bili_0428;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int k = 0; k < t; k++) {
//            int m = in.nextInt();
//            int n = in.nextInt();
//            int[][] mat = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    mat[i][j] = in.nextInt();
//                }
//            }
//            int[] ans = ans(mat);
//            System.out.println(ans[1] + " " + ans[0]);
//        }
//    }
//
//    private static int[] ans(int[][] mat) {
//        int[] res = new int[2];
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j] > 0) {
//                    res[0] = Math.max(res[0], dfs(i, j, mat));
//                    res[1] += 1;
//                }
//            }
//        }
//        return res;
//    }
//
//    static int[][] dirs = new int[][]{
//            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
//    };
//
//    private static int dfs(int i, int j, int[][] mat) {
//        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
//            return 0;
//        }
//        if (mat[i][j] < 1) {
//            return 0;
//        }
//        int cnt = mat[i][j];
//        mat[i][j] = 0;
//        for (int k = 0; k < dirs.length; k++) {
//            int x = dirs[k][0] + i;
//            int y = dirs[k][1] + j;
//            cnt += dfs(x, y, mat);
//        }
//        return cnt;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vals = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            vals[i] = in.nextInt();
            map.put(vals[i], i);
        }
//        ArrayList<ArrayList<Integer>> adjs = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            adjs.add(new ArrayList<>());
//        }
//        for (int i = 1; i < n; i++) {
//            int n1 = in.nextInt();
//            int n2 = in.nextInt();
//            adjs.get(n1).add(n2);
//            adjs.get(n2).add(n1);
//        }
        // 3 4 2 1 5
        //
        // 1 4 2 3 5
        // 1 2 4 3 5
        // 1 2 3 4 5
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (vals[i] != i) {
                int ti = map.get(i);
                // System.out.println(Arrays.toString(vals));
                map.put(i, i);
                map.put(ti, vals[i]);
                swap(vals, i, ti);
                ans += 1;
            }
        }
        System.out.println(ans);
    }

    private static void swap(int[] vals, int i1, int i2) {
        int tmp = vals[i1];
        vals[i1] = vals[i2];
        vals[i2] = tmp;
    }
}

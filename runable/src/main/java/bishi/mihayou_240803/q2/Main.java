package bishi.mihayou_240803.q2;

import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static int n;
    static int m;
    static int[][] items;
    static boolean[][] mat;
    static HashMap<String, Long> cache = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 商品数量
        n = in.nextInt();
        // 背包容量
        m = in.nextInt();
        // 互斥数量
        int k = in.nextInt();
        items = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            // 体积
            items[i][0] = in.nextInt();
            // 价值
            items[i][1] = in.nextInt();
        }
        mat = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            int idA = in.nextInt();
            int idB = in.nextInt();
            mat[idA][idB] = true;
            mat[idB][idA] = true;
        }
        System.out.println(dfs(1, m, 0));
    }

    // dfs(i, lm, stat) = dfs(i + 1, lm, stat)
    private static long dfs(int i, int lm, int stat){
        if (i > n){
            return 0;
        }
        String key = i + "#" + lm + "#" + stat;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        long res = dfs(i + 1, lm, stat);
        if (((1 << i) & stat) > 0) {
            return res;
        }
        if (items[i][0] > lm) {
            return res;
        }
        stat = ((1 << i) | stat);
        for (int j = 1; j <= n; j++) {
            if (mat[i][j]) {
                stat = ((1 << j) | stat);
            }
        }
        res = Math.max(items[i][1] + dfs(i + 1, lm - items[i][0], stat), res);
        cache.put(key, res);
        return res;
    }
}
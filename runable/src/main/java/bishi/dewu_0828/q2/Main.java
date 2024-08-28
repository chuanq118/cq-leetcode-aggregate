package bishi.dewu_0828.q2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pointsA = new int[n];
        int[] pointsB = new int[n];
        for (int i = 0; i < n; i++) {
            pointsA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pointsB[i] = in.nextInt();
        }
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            long diffA = (long) pointsA[i] - (long) pointsA[i - 1];
            long diffB = (long) pointsB[i] - (long) pointsB[i - 1];
            if (diffA == diffB) {
                cnt += 1;
            } else {
                if (cnt > 0) {
                    ans = Math.max(ans, cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(Math.max(ans, cnt));
    }
}

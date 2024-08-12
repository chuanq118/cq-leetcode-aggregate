package bishi.pdd_0811.q1;

import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = new int[n][3];
        for (int i = 0; i < n; i++) {
            mat[i][0] = in.nextInt();
            mat[i][1] = in.nextInt();
            mat[i][2] = in.nextInt();
        }
        Arrays.sort(mat, (prev, next) -> prev[0] - next[0]);
        int curDay = 0;
        for (int[] vis : mat) {
            if (curDay < vis[1]){
                curDay = vis[1];
            }else{
                curDay += (vis[2] - ((curDay - vis[1]) % vis[2]));
            }
        }
        System.out.println(curDay);
    }
}

import java.util.*;
/**
小美有一个矩形的蛋糕，共分成了 n 行 m 列，共 n * m 个区域，每个区域是一个小正方形，已知蛋糕每个区域都有一个美味度。

她想切一刀把蛋糕切成两部分，自己吃一部分，小团吃另一部分。 

小美希望两个人吃的部分的美味度之和尽可能接近，请你输出|s1 - s2|的最小值。（其中 s1 代表小美吃的美味度，s2 代表小团吃的美味度）。 请务必保证，切下来的区域都是完整的，即不能把某个小正方形切成两个小区域。
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < m; j += 1){
                mat[i][j] = in.nextInt();
            }
        }
        int[][] sumMat = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i += 1){
            for(int j = 1; j <= m; j += 1){
                sumMat[i][j] = sumMat[i - 1][j] + sumMat[i][j - 1] - sumMat[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i += 1){
            ans = Math.min(Math.abs(sumMat[n][m] - sumMat[i][m] - sumMat[i][m]), ans);
        }
        for(int j = 1; j < m; j += 1){
            ans = Math.min(Math.abs(sumMat[n][m] - sumMat[n][j] - sumMat[n][j]), ans);
        }
        System.out.println(ans);
    }
}
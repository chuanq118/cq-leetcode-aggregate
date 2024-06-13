package cn.lqs.now_coder.美团2024届秋招笔试第一场编程真题.Q6;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] sum = new long[n+1];
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + in.nextLong();
        }
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        long p1 = Math.abs(sum[x] - sum[y]);
        long p2 = Math.abs(sum[n] - p1);
        System.out.print(Math.min(p1, p2));
    }
}
package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q6;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int left = 1024 - in.nextInt();
        int n1 = left / 64;
        left %= 64;
        int n2 = left / 16;
        left %= 16;
        int n3 = left / 4;
        left %= 4;
        System.out.println(n1+n2+n3+left);
    }
}
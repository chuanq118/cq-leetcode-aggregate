package cn.lqs.bishi.meituan_240323;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) throws Exception {
        System.in.read("2 3".getBytes());
        System.in.read("110".getBytes());
        System.in.read("010".getBytes());
        Scanner in = new Scanner(System.in);
        System.out.println("hello world!");
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println("hello world!");
        in.nextLine();
        System.out.println("hello world!");
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = in.nextLine().toCharArray();
        }
        
        System.out.println(n);
        System.out.println(m);
        System.out.println(new String(mat[0]));
        System.out.println(new String(mat[1]));
        // System.out.println("hello world!");
    }
}

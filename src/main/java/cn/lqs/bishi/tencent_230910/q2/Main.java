package cn.lqs.bishi.tencent_230910.q2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n - 1];
            for (int i1 = 0; i1 < n; i1++) {
                arr1[i1] = in.nextInt();
            }
            for (int i2 = 0; i2 < n - 1; i2++) {
                arr2[i2] = in.nextInt();
            }
            Arrays.sort(arr1);
            int len1 = arr1.length;
            int mi1 = len1 % 2 == 0 ? (len1 / 2) - 1 : len1 / 2;
            int mi2 = len1 % 2 == 0 ? ()
        }
    }
}

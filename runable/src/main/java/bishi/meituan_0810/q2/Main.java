package bishi.meituan_0810.q2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            long k = in.nextInt();
            long x = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            long minVal = (long) minNonNegNum(arr);
            long minCost = Long.MAX_VALUE;
            long cost2 = 0;
            for (int j = 0; j < arr.length; j++) {
                long cost1 = minVal * k;
                minCost = Math.min(minCost, cost1 + cost2);
                cost2 += x;
                minVal = Math.min(minVal, arr[j]);
            }
            System.out.println(Math.min(minCost, cost2));
        }
    }

    private static int minNonNegNum(int[] arr){
        boolean[] arrCopy = new boolean[arr.length + 1];
        for (int j : arr) {
            arrCopy[j] = true;
        }
        for (int i = 0; i < arr.length + 1; i++) {
            if (!arrCopy[i]) {
                return i;
            }
        }
        return arr.length + 1;
    }
}
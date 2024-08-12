package bishi.pdd_0811.q3;

import java.util.HashSet;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (in.nextInt() == 0) {
                arr1[i] = arr1[i - 1] + 1;
                arr2[i] = arr2[i - 1];
            }else {
                arr2[i] = arr2[i - 1] + 1;
                arr1[i] = arr1[i - 1];
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(Math.abs(arr2[n] - arr1[n]));
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int num1 = arr1[j] - arr1[i];
                int num2 = arr2[j] - arr2[i];
                int diff1 = arr2[n] + num1 - num2;
                int diff2 = arr1[n] + num2 - num1;
                set.add(Math.abs(diff1 - diff2));
            }
        }
        System.out.println(set.size());
    }
}

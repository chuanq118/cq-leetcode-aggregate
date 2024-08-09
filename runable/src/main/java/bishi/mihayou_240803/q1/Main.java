package bishi.mihayou_240803.q1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            long v1 = (long) nums[i] * (long) nums[i + 1];
            long v2 = (long) nums[i] * (long) nums[i + 2];
            ans = Math.max(Math.max(v1, v2), ans);
        }
        ans = Math.max((long) nums[nums.length - 2] * nums[nums.length - 1], ans);
        System.out.println(ans);
    }
}
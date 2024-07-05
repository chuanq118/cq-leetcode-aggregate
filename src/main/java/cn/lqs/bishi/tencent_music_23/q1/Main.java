package cn.lqs.bishi.tencent_music_23.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i += 1) {
            nums[i] = in.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                if (isPerfectNumber((long) nums[i] * nums[j])) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isPerfectNumber(long num) {
        if (num < 10) {
            return true;
        }
        while (num % 10 == 0) {
            num /= 10;
        }
        return num < 10;
    }
}

package bishi_pre.jd_230923.q2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 15;
        int[] arr = new int[n];
        arr[0] = 9;
        arr[1] = 8;
        for (int i = 1; i <= 7; i++) {
            arr[i + 1] = i;
        }
        for (int i = 1; i <= 6; i++) {
            arr[i + 8] = i;
        }
        System.out.println(Arrays.toString(arr));
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                cnt += 1;
            }else {
                cnt += 1;
                if (cnt > 2) {
                    ans += ((cnt - 1) / 2);
                }
                cnt = 0;
            }
        }
        cnt += 1;
        if (cnt > 2) {
            ans += ((cnt - 1) / 2);
        }
        System.out.println(ans);
        arr[3] = 999;
        arr[5] = 999;
        arr[7] = 999;
        arr[10] = 999;
        arr[12] = 999;
        System.out.println(Arrays.toString(arr));
    }
}

package bishi_pre.jd_230923.q1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {2, 4, 10, 1, 3};
        int[] arr2 = {14, 4, 6, 7, 3};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int cur1 = 0;
        int cur2 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[cur1] < arr2[cur2]) {
                ans += arr1[cur1];
                cur1 += 1;
            }else {
                ans += arr2[cur2];
                cur2 += 1;
            }
        }
        System.out.println(ans);
    }
}

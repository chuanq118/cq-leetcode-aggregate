package cn.lqs.bishi.tencent_230910.q1;

import java.util.Scanner;

public class Main {

    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int ci, int preVal) {
        if (arr[ci] == -1) {
            if (preVal == 1){
                ans += 1;
            }
            return;
        }
        preVal += (arr[ci] == 0 ? -1 : 1);
        int li = 2 * ci + 1;
        if (li < arr.length) {
            dfs(li, preVal);
        }else {
            if (preVal == 1){
                ans += 1;
            }
            return;
        }
        int ri = 2 * ci + 2;
        if (ri < arr.length) {
            dfs(ri, preVal);
        }else {
            if (preVal == 1){
                ans += 1;
            }
        }
    }
}

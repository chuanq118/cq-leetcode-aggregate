package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q5;

import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    static int[][] ADJ;
    static int N;
    static HashMap<String, Integer> MEMO;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        ADJ = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ADJ[i][j] = in.nextInt();
            }
        }
        MEMO = new HashMap<>();
        int MAX = 0;
        for(int i = 1; i < N; i++){
            MAX = (1 << i) | MAX;
        }
        System.out.print(dfs(0, 0, MAX));
    }

    private static int dfs(int i, int j, int mask){
        if(0 == mask){
            return ADJ[i][j];
        }
        String key = i + "#" + j + "#" + mask;
        if (MEMO.containsKey(key)){
            return MEMO.get(key);
        }
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < N; k++){
            int kv = 1 << k;
            if ((mask & kv) != 0){
                ans = Math.min(ans, dfs(i, k, mask & (~kv)) + ADJ[k][j]);
            }
        }
        MEMO.put(key, ans);
        return ans;
    }
}
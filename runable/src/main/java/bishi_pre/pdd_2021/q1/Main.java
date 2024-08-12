package bishi_pre.pdd_2021.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int n = 32;
        dfs(n, new boolean[10], new ArrayList<>());
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int lf, boolean[] used, List<Integer> clt) {
        if (lf <= 0) return;
        if (lf <= 9){
            if (used[lf]) return;
            ArrayList<Integer> copyed = new ArrayList<>(clt);
            copyed.add(lf);
            copyed.sort((n1, n2) -> n1 - n2);
            int base = lf;
            for (int i = 1; i < copyed.size(); i++) {
                base = copyed.get(i) + (base * 10);
            }
            ans = Math.min(ans, base);
            return;
        }
        for (int i = 9; i >= 1; i -= 1) {
            if (used[i]) continue;
            clt.add(i);
            used[i] = true;
//            System.out.println(clt);
//            System.out.println(Arrays.toString(used));
            dfs(lf - i, used, clt);
            used[i] = false;
            clt.remove(clt.size() - 1);
        }
    }

}


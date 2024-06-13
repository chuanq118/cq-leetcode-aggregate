package cn.lqs.now_coder.美团2024届秋招笔试第一场编程真题.Q3;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n+1];
        for(int i = 1; i <= n; i++){
            weights[i] = in.nextInt();
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        boolean[] colored = new boolean[n+1];
        Deque<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(adj.get(i).size() == 1){
                Q.offer(i);
            }
        }
        while (!Q.isEmpty()) {
            int polled = Q.poll();
            if (adj.get(polled).size() != 1) {
                continue;
            }
            int neighbor = adj.get(polled).get(0);
            if (colored[polled] || colored[neighbor]){
                adj.get(polled).clear();
                adj.get(neighbor).remove((Integer) polled);
                if (adj.get(neighbor).size() == 1) {
                    Q.offer(neighbor);
                }
                continue;
            }
            if (check(weights[polled], weights[neighbor])) {
                colored[polled] = true;
                colored[neighbor] = true;
            }
            adj.get(neighbor).remove((Integer) polled);
            adj.get(polled).clear();
            if (adj.get(neighbor).size() == 1) {
                Q.offer(neighbor);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (colored[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int v1, int v2) {
        int r1 = v1 * v2;
        int r2 = (int) Math.sqrt(r1);
        return r1 == (r2 * r2);
    }
}
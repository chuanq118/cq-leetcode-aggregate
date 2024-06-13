package cn.lqs.leetcode_2603;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }
        boolean[] removed = new boolean[n];
        boolean needMoreRemove = true;
        HashSet<Integer> collector = new HashSet<>();
        while (needMoreRemove) {
            needMoreRemove = false;
            collector.clear();
            for (int i = 0; i < n; i++) {
                if (!removed[i] && adjs.get(i).size() == 1 && coins[i] == 0) {
                    needMoreRemove = true;
                    removed[i] = true;
                    collector.add(i);
                }
            }
            for (Integer i : collector) {
                for (int j : adjs.get(i)) {
                    adjs.get(j).remove((Integer) i);
                }
            }
        }
        for (int k = 0; k < 2; k++) {
            collector.clear();
            for (int i = 0; i < n; i++) {
                if (!removed[i] && adjs.get(i).size() == 1) {
                    removed[i] = true;
                    collector.add(i);
                }
            }
            for (Integer i : collector) {
                for (int j : adjs.get(i)) {
                    adjs.get(j).remove((Integer) i);
                }
            }
        }
        int leftNum = 0;
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                leftNum++;
            }
        }
        return leftNum == 0 ? 0 : 2 * (leftNum - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 0, 0, 0, 0, 1};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solution.collectTheCoins(coins, edges));
    }
}

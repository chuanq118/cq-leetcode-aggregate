package cn.lqs.leetcode_2000_plus.leetcode_2861;

import java.util.List;

class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition,
                                 List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        int maxStock = 0;
        for (int i = 0; i < n; i++) {
            maxStock = Math.max(stock.get(i), maxStock);
        }
        int r = maxStock + budget / n;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, bFind(r, n, budget, composition.get(i), stock, cost));
        }
        return ans;
    }

    private int bFind(int r, int n, int budget, List<Integer> comp, List<Integer> stock, List<Integer> cost) {
        int l = 0;
        while (l <= r) {
            int num = (l + r) >> 1;
            long cos = 0L;
            for (int i = 0; i < n; i++) {
                cos += Math.max((long) comp.get(i) * (long) num - (long) stock.get(i), 0L) * (long) cost.get(i);
            }
            if (cos <= budget) {
                l = num + 1;
            } else {
                r = num - 1;
            }
        }
        return l - 1;
    }

}
package cn.lqs.leetcode_2698;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    private final HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int t = i * i;
            if (isPunishmentNumber(t, i)) {
                result += t;
            }
        }
        return result;
    }

    private boolean isPunishmentNumber(int t, int i) {
        ArrayList<Integer> sums = computeAllSums(String.valueOf(t));
        for (int sum : sums) {
            if (sum == i) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Integer> computeAllSums(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length() == 1) {
            ArrayList<Integer> res = new ArrayList<>(1);
            res.add(Integer.parseInt(s));
            map.put(s, res);
            return res;
        } else {
            ArrayList<Integer> totalResult = new ArrayList<>();
            for (int k = 1; k < s.length(); k++) {
                ArrayList<Integer> left = computeAllSums(s.substring(0, k));
                ArrayList<Integer> right = computeAllSums(s.substring(k));
                for (int j : left) {
                    for (int value : right) {
                        totalResult.add(j + value);
                    }
                }
            }
            totalResult.add(Integer.parseInt(s));
            map.put(s, totalResult);
            return totalResult;
        }
    }
}
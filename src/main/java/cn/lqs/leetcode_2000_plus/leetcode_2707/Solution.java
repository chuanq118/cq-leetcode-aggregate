package cn.lqs.leetcode_2000_plus.leetcode_2707;

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> cache;
    String str;
    int minLen;
    int maxLen;
    SearchTree searchTree;

    public int minExtraChar(String s, String[] dictionary) {
        this.searchTree = new SearchTree();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String dict : dictionary) {
            minLen = Math.min(minLen, dict.length());
            maxLen = Math.max(maxLen, dict.length());
            searchTree.add(dict);
        }
        // dp[i+1] = min(dp[i]+1, dp[j]) (j=i-Len(sub))
        int[] dp = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            dp[i+1] = dp[i] + 1;
            for (int j = i+minLen; j <= i+maxLen && j <= s.length(); j++) {
                if (this.searchTree.search(s.substring(i, j))) {
                    dp[i+1] = Math.min(dp[i+1], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }

    // public int minExtraChar(String s, String[] dictionary) {
    //     this.searchTree = new SearchTree();
    //     this.minLen = Integer.MAX_VALUE;
    //     this.maxLen = Integer.MIN_VALUE;
    //     for (String dict : dictionary) {
    //         minLen = Math.min(minLen, dict.length());
    //         maxLen = Math.max(maxLen, dict.length());
    //         searchTree.add(dict);
    //     }
    //     this.str = s;
    //     this.cache = new HashMap<>();
    //     return dfs(0);
    // }

    // private int dfs(int k) {
    //     if(k < 0 || k >= str.length()) return 0;
    //     // if (k > (str.length()-minLen)) return str.length() - k;
    //     if (this.cache.containsKey(k)) {
    //         return this.cache.get(k);
    //     }
    //     int times = dfs(k + 1) + 1;
    //     for (int i = k + minLen; i <= str.length() && i <= k + maxLen; i++) {
    //         if (this.searchTree.search(str.substring(k, i))) {
    //             times = Math.min(times, dfs(i));
    //         }
    //     }
    //     this.cache.put(k, times);
    //     return times;
    // }

    static class SearchTree {
        SearchTree[] nodes;
        boolean leaf;

        SearchTree() {
            this.nodes = new SearchTree[26];
            this.leaf = false;
        }

        boolean search(String s) {
            SearchTree node = this;
            for (char c : s.toCharArray()) {
                if (node.nodes[c - 'a'] == null)
                    return false;
                node = node.nodes[c - 'a'];
            }
            return node.leaf;
        }

        void add(String s) {
            SearchTree node = this;
            for (char c : s.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new SearchTree();
                }
                node = node.nodes[c - 'a'];
            }
            node.leaf = true;
        }
    }

    public static void main(String[] args) {
        String[] dicts = new String[]{"hello","world"};
        int leetscode = new Solution().minExtraChar("sayhelloworld", dicts);
        System.out.println("leetscode = " + leetscode);
    }
}
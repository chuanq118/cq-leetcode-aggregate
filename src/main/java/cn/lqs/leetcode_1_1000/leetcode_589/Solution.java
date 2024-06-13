package cn.lqs.leetcode_1_1000.leetcode_589;

import cn.lqs.struct.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root != null) {
            ans.add(root.val);
            for (Node child : root.children) {
                dfs(child);
            }
        }
    }


}
package cn.lqs.leetcode_1_1000.leetcode_590;

import cn.lqs.struct.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {

    final List<Integer> arr = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return arr;
    }

    private void dfs(Node node) {
        if (node != null) {
            for (Node child : node.children) {
                dfs(child);
            }
            arr.add(node.val);
        }
    }
}
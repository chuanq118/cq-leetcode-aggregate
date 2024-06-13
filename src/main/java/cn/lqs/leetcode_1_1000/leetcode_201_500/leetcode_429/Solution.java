package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_429;

import cn.lqs.struct.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int n = Q.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node polled = Q.poll();
                curList.add(polled.val);
                for (Node child : polled.children) {
                    if (child != null) {
                        Q.offer(child);
                    }
                }
            }
            ans.add(curList);
        }
        return ans;
    }
}
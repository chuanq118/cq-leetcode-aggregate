package cn.lqs.leetcode_2000_plus.leetcode_2641;

import cn.lqs.struct.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int preSum = root.val;
        while (!dq.isEmpty()) {
            int n = dq.size();
            int curSum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = dq.poll();
                int newVal = preSum - node.val;
                if (map.containsKey(node)) {
                    newVal -= map.get(node);
                }
                node.val = newVal;
                boolean hasL = node.left != null;
                boolean hasR = node.right != null;
                if (hasL) {
                    dq.offer(node.left);
                    curSum += node.left.val;
                }
                if (hasR) {
                    dq.offer(node.right);
                    curSum += node.right.val;
                }
                if (hasL && hasR) {
                    map.put(node.left, node.right.val);
                    map.put(node.right, node.left.val);
                }
            }
            preSum = curSum;
        }
        return root;
    }
}
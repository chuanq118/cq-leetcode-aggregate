package cn.lqs.leetcode_1_1000.leetcode_513;

import cn.lqs.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
      Deque<TreeNode> dq = new LinkedList<>();
      dq.offer(root);
      while(!dq.isEmpty()){
          dq.size();
        dq.poll();
      }
        return 0;
    }
}
package cn.lqs.leetcode_2000_plus.leetcode_2451;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
      Queue<TreeNode> Q = new LinkedList<>();
      Q.offer(root);
      int level = 0;
      Stack<TreeNode> parents = new Stack<>();
      while(!Q.isEmpty()){
        int n = (int) Math.pow(2, level);
        if (n == 1){
          TreeNode rNode = Q.poll();
          parents.push(rNode);
          if (rNode.left != null) {
            Q.offer(rNode.left);
            Q.offer(rNode.right);
          }
          level++;
          continue;
        }
        boolean isReverse = level % 2 != 0;
        Stack<TreeNode> tmpParents = new Stack<>();
        for(int i = 0; i < n; i+=2){
          TreeNode lNode = Q.poll();
          TreeNode rNode = Q.poll();
          tmpParents.push(lNode);
          tmpParents.push(rNode);
          if(lNode.left != null){
            Q.offer(lNode.left);
            Q.offer(lNode.right);
            Q.offer(rNode.left);
            Q.offer(rNode.right);
          }
          TreeNode pNode = parents.pop();
          if(isReverse){
            pNode.left = rNode;
            pNode.right = lNode;
          } else {
            pNode.left = lNode;
            pNode.right = rNode;
          }
        }
        parents = tmpParents;
        level++;
      }
      return root;
    }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
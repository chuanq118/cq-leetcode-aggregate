package cn.lqs.leetcode_1_1000.leetcode_897;

import cn.lqs.struct.TreeNode;

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] ans = dfs(root);
        return ans[0];
    }

    private TreeNode[] dfs(TreeNode root) {
        if (root != null) {
            TreeNode[] lNodes = dfs(root.left);
            if (lNodes[1] != null) {
                lNodes[1].right = root;
            }
            root.left = null;
            TreeNode[] rNodes = dfs(root.right);
            if (rNodes[0] != null){
                root.right = rNodes[0];
            }
            return new TreeNode[]{lNodes[0] == null ? root : lNodes[0],
                    rNodes[1] == null ? root : rNodes[1]};
        }
        return new TreeNode[]{null, null};
    }

}
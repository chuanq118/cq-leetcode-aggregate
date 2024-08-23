package bishi.tme_0823.q2;

import javax.swing.tree.TreeNode;
import java.util.*;





public class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return TreeNode类
     */
    public TreeNode makeCompleteTree (TreeNode root) {
        // write code here
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        while (!dq.isEmpty()) {
            int n = dq.size();
            boolean isLeaf = true;
            for (int i = 0; i < n; i++) {
                TreeNode cur = dq.pollLast();
                if (isLeaf) {
                    if (cur.left != null) {
                        if (cur.left.left != null || cur.left.right != null) {
                            isLeaf = false;
                        }
                    }
                    if (cur.right != null) {
                        if (cur.right.left != null || cur.right.right != null) {
                            isLeaf = false;
                        }
                    }
                }
                dq.offerFirst(cur);
            }
            if (!isLeaf) {
                for (int i = 0; i < n; i++) {
                    TreeNode cur = dq.pollLast();
                    if (cur.right == null) {
                        cur.right = new TreeNode(1);
                    }
                    if (cur.left == null) {
                        cur.left = new TreeNode(1);
                    }
                    dq.offerFirst(cur.right);
                    dq.offerFirst(cur.left);
                }
            }else {
                boolean isPadding = false;
                for (int i = 0; i < n; i++) {
                    TreeNode cur = dq.pollLast();
                    if (isPadding && cur.right == null) {
                        cur.right = new TreeNode(1);
                    }
                    if (!isPadding && cur.right != null) {
                        isPadding = true;
                    }
                    if (isPadding && cur.left == null){
                        cur.left = new TreeNode(1);
                    }
                    if (!isPadding && cur.left != null) {
                        isPadding = true;
                    }
                }
            }

        }
        return root;
    }
}
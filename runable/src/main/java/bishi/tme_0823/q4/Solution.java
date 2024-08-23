package bishi.tme_0823.q4;

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
     * @param leaf string字符串一维数组 
     * @param value int整型一维数组 
     * @return TreeNode类
     */
    public TreeNode recoverHuffman (String[] leaf, int[] value) {
        // write code here
        int n = leaf.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (pre, nxt) -> leaf[nxt].length() - leaf[pre].length());
        for (int i = 0; i < n; i++) {
            mp.put(leaf[idx[i]], new TreeNode(value[idx[i]]));
        }
        for (int i = 0; i < n; i++) {
            int i_ = idx[i];
            int ei = leaf[i_].length() - 1;
            String pCode = leaf[i_].substring(0, ei);
            if (!mp.containsKey(pCode)) {
                String neCh = pCode + (leaf[i_].charAt(ei) == '0' ? "1" : "0");
                TreeNode rNode = mp.get(neCh);
                int weight = rNode == null ? 0 : rNode.val;
                weight += mp.get(leaf[i_]).val;
                mp.put(pCode, new TreeNode(weight));
            }
        }
        return dfs("");
    }

    final HashMap<String, TreeNode> mp = new HashMap<>();

    private TreeNode dfs(String code) {
        if (!mp.containsKey(code)) {
            return null;
        }
        TreeNode root = mp.get(code);
        TreeNode leftRoot = dfs(code + "0");
        if (leftRoot != null) {
            root.left = leftRoot;
        }
        TreeNode rightNode = dfs(code + "1");
        if (rightNode != null) {
            root.right = rightNode;
        }
        return root;
    }

    public static void main(String[] args) {
        new Solution().recoverHuffman(new String[]{"0", "10", "11"}, new int[]{2, 1, 2});
    }
}
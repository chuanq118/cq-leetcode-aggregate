package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    int m;
    int n;
    char[][] board;
    Trie trie = new Trie();
    HashSet<String> clt = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.add(word);
        }
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        boolean[][] visited = new boolean[this.m][this.n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, trie.root, visited);
                visited[i][j] = false;
            }
        }

        List<String> ans = new ArrayList<>(clt.size());
        for (String s : clt) {
            ans.add(s);
        }
        return ans;
    }

    public void dfs(int x, int y, int depth, TrieNode tNode, boolean[][] visited) {
        if (depth > 9){
            return;
        }
        TrieNode curNode = tNode.children[board[x][y] - 'a'];
        if (curNode == null) {
            return;
        }
        if (curNode.isLeaf) {
            clt.add(curNode.word);
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, curNode, visited);
                visited[nx][ny] = false;
            }
        }
    }

    static class Trie {

        TrieNode root = new TrieNode(-1);

        public void add(String word){
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curNode.children[idx] == null) {
                    curNode.children[idx] = new TrieNode(i);
                }
                curNode = curNode.children[idx];
            }
            curNode.markLeaf();
            curNode.setWord(word);
        }

        public TrieNode searchPrefix(String preWord) {
            TrieNode cur = root;
            for (int i = 0; i < preWord.length(); i++) {
                int idx = preWord.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    return null;
                }
                cur = cur.children[idx];
            }
            return cur;
        }
    }

    static class TrieNode {
        boolean isLeaf = false;
        TrieNode[] children = new TrieNode[26];
        String word = null;
        final int depth;

        public TrieNode(int depth) {
            this(depth, false);
        }
        public TrieNode(int depth, boolean isLeaf) {
            this.isLeaf = isLeaf;
            this.depth = depth;
        }

        public void markLeaf() {
            this.isLeaf = true;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

}
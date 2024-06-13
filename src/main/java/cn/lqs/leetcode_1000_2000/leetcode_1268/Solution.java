package cn.lqs.leetcode_1268;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = solution.suggestedProducts(products, searchWord);
        System.out.println(result);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        List<List<String>> result = new ArrayList<>(searchWord.length());
        for(String product : products){
            insert(product, root);
        }
        // 逐个搜索
        Node cur = root;
        boolean ok = true;
        String prefix = "";
        for(char ch : searchWord.toCharArray()){
            if(!ok){
                result.add(new ArrayList<String>());
                continue;
            }
            int idx = ch - 'a';
            prefix += ch;
            ok = cur.children[idx] != null;
            if(ok){
                cur = cur.children[idx];
                result.add(findThreeProducts(cur, prefix));
            }
        }
        return result;
    }


    private List<String> findThreeProducts(Node node, String prefix){
        List<String> list = new ArrayList<>(3);
        if(node.leaf){
            list.add(prefix);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        findProduct(node, sb, list);
        return list;
    }

    private void findProduct(Node node, StringBuilder sb, List<String> collector){
        for(int i = 0; i < 26; i++){
            if(collector.size() > 2){
                return;
            }
            Node cur = node.children[i];
            if(cur != null){
                sb.append((char) (i + 97));
                if(cur.leaf){
                    collector.add(sb.toString());
                }
                findProduct(cur, sb, collector);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void insert(String word, Node root){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
            if(i == word.length() - 1){
                cur.leaf = true;
            }
        }
    }

    static class Node{
        boolean leaf;
        Node[] children;

        public Node(){
            this(false, new Node[26]);
        }

        public Node(boolean leaf){
            this(leaf, new Node[26]);
        }

        public Node(boolean leaf, Node[] children){
            this.leaf = leaf;
            this.children = children;
        }
    }
}
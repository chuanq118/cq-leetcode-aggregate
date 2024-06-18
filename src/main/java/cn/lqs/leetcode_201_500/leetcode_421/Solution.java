package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_421;

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int max = 0;
        for(int i = 1; i <= nums.length; i++){
            trie.add(nums[i - 1]);

        }
        return max;
    }

    private int selectMaxXOR(Trie root, int num) {
        return 0;
    }

    static class Trie{
      Trie[] children;
      
      public Trie(){
        this.children = new Trie[2];
      }

      private void add(int num){
        Trie node = this;
        for(int i = 31; i >= 0; i--){
          if(((1 << i) & num) == 0){
              if (node.children[0] == null) {
                  node.children[0] = new Trie();
              }
              node = node.children[0];
          }else{
              if (node.children[1] == null) {
                  node.children[1] = new Trie();
              }
                node = node.children[1];
          }
        }
      }
    }
}
package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_127;

import java.util.*;

class Solution {

    // HashSet<String> hSet = new HashSet<>();
    // String endWord;
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     for(String word : wordList){
    //         hSet.add(word);
    //     }
    //     if(!hSet.contains(endWord)){
    //         return 0;
    //     }
    //     this.endWord = endWord;
    //     int ans = dfs(beginWord, 0);
    //     return ans == -1 ? 0 : ans + 1;
    // }
    //
    // private int dfs(String word, int depth){
    //     if(word.equals(this.endWord)){
    //         return depth;
    //     }
    //     if(hSet.size() == 0){
    //         return -1;
    //     }
    //     int ans = Integer.MAX_VALUE;
    //     char[] chs = word.toCharArray();
    //     for(int i = 0; i < chs.length; i++){
    //         char ci = chs[i];
    //         for(int j = 0; j < 26; j++){
    //             char c = (char)(j + 'a');
    //             if(c != ci){
    //                 chs[i] = c;
    //                 String nWord = new String(chs);
    //                 if(hSet.contains(nWord)){
    //                     hSet.remove(nWord);
    //                     int res = dfs(nWord, depth + 1);
    //                     if(res != -1){
    //                         ans = Math.min(ans, res);
    //                         hSet.add(nWord);
    //                     }
    //                 }
    //             }
    //         }
    //         chs[i] = ci;
    //     }
    //     return ans == Integer.MAX_VALUE ? -1 : ans;
    // }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Deque<String> dq = new LinkedList<>();
        dq.offer(beginWord);
        visited.add(beginWord);
        int ans = 1;
        while (!dq.isEmpty()) {
            int choice = dq.size();
            for (int k = 0; k < choice; k++) {
                String word = dq.poll();
                char[] wordArr = word.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char oc = wordArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch += 1) {
                        if (ch == oc) {
                            continue;
                        }
                        wordArr[i] = ch;
                        String nextWord = new String(wordArr);
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return ans + 1;
                            }
                            dq.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    wordArr[i] = oc;
                }
            }
            ans += 1;
        }
        return 0;
    }
}
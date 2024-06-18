package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for(String str : strs){
        String key = sortChars(str);
        if (!map.containsKey(key)) {
          map.put(key, new ArrayList<>());
        }
        map.get(key).add(str);
      }
      List<List<String>> result = new ArrayList<>(map.size());
      result.addAll(map.values());
      return result;
    }

    private String sortChars(String s){
      char[] chs = s.toCharArray();
      char[] sorted = new char[chs.length];
      for(int k = 0; k < chs.length; k++){
        int i = 0;
        for(; i < k; i++){
          if(sorted[i] > chs[k]) break;
        }
        if(i < k){
          for(int j = k; j > i; j--){
            sorted[j] = sorted[j - 1];
          } 
        }
        sorted[i] = chs[k];
      }
      return new String(sorted);
    }
}
package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_318;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

class Solution {
    public int maxProduct(String[] words) {
      HashSet<String>[] sets = new HashSet[26];
      for(String word : words){
        for(char ch : word.toCharArray()){
          int idx = ch - 'a';
          if(sets[idx] == null){
            sets[idx] = new HashSet<String>();
          }
          sets[idx].add(word);
        }
      }
      HashSet<String> tmpSet = new HashSet<>();
      int max = 0;
      for(int i = 0; i < words.length; i++){
        tmpSet.clear();
        int n = words[i].length();
        for(char ch : words[i].toCharArray()){
          tmpSet.addAll(sets[ch - 'a']);
        }
        for(int j = 0; j < words.length; j++){
          if(i == j) continue;
          if(!tmpSet.contains(words[j])){
            max = Math.max(max, words[j].length() * n);
          }
        }
      }
      return max;
    }

  public static void main(String[] args) throws Exception{
    String[] words = JSONObject.parseObject(FileUtils.readFileToString(new File("D:\\temp\\strings.json"), StandardCharsets.UTF_8), new TypeReference<String[]>() {
    });
    System.out.println(new Solution().maxProduct(words));
  }

}
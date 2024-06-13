package cn.lqs.leetcode_2127;

import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {
      int circleSize = bfs(favorite);
      if(circleSize == 2){
        circleSize = bfs2(favorite);
        return circleSize;
      }
      return Math.max(circleSize, bfs2(favorite));
    }

    // 已知存在两个长度环,求最大路径
    private int bfs2(int[] favorite){
      // 需要检查每个节点作为开始节点所能到达的最大长度

      // 保存两个环其中节点作为开始节点所能到达的最大长度
      int[] repeatCount = new int[favorite.length];
      for(int i = 0; i < favorite.length; i++){
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[favorite.length];
        Q.offer(i);
        int count = 0;
        while(!Q.isEmpty()){
          int idx = Q.poll();
          visited[idx] = true;
          count++;
          if(!visited[favorite[idx]]){
            Q.offer(favorite[idx]);
          }else{
            // 排除非 2 个的环
            if(idx == favorite[favorite[idx]]){
              repeatCount[favorite[idx]] = Math.max(repeatCount[favorite[idx]], count);
            }
            break;
          }
        }
      }
      int maxLen = 0;
      for (int i = 0; i < favorite.length; i++) {
        if(repeatCount[i] > 0){
          repeatCount[i] = repeatCount[i] + repeatCount[favorite[i]] - 2;
          maxLen += repeatCount[i];
          repeatCount[favorite[i]] = 0;
        }
      }
      return maxLen;
    }

    // 计算环长度
    private int bfs(int[] favorite){
      int maxLen = 0;
      for (int i = 0; i < favorite.length; i++) {
        boolean[] visited = new boolean[favorite.length];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        List<Integer> list = new ArrayList<>();
        int tar = -1;
        while(!Q.isEmpty()){
          int idx = Q.poll();
          tar = favorite[idx];
          list.add(idx);
          visited[idx] = true;
          if(!visited[tar]){
            Q.offer(tar);
          }else{
            break;
          }
        }
        int j = 0;
        for(; j < list.size(); j++){
          if(list.get(j) == tar){
            break;
          }
        }
        maxLen = Math.max(maxLen, list.size() - j);
      }
      return maxLen;
    }

    public static void main(String[] args) {
      Solution solution = new Solution();
      int[] favorite = new int[]{8,16,14,19,14,10,18,5,1,0,17,20,18,3,8,13,14,6,3,5,0};
      System.out.println(solution.maximumInvitations(favorite));
    }
}
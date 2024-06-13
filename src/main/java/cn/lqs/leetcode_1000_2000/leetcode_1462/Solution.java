package cn.lqs.leetcode_1462;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      ArrayList<HashSet<Integer>> courses = new ArrayList<>(numCourses);
      for(int i = 0; i < numCourses; i++){
        courses.add(new HashSet<Integer>());
      }
      for(int[] prerequisite : prerequisites){
        courses.get(prerequisite[1]).add(prerequisite[0]);
      }
      boolean[] flag = new boolean[numCourses];
      compress(courses, flag);
      List<Boolean> result = new ArrayList<>(queries.length);
      for(int[] query : queries){
        result.add(courses.get(query[1]).contains(query[0]));
        // result.add(isPre(query[0], query[1], courses));
      }
      return result;
    }

    private void compress(ArrayList<HashSet<Integer>> courses, boolean[] flag){
      for(int i = 0; i < courses.size(); i++){
        Integer[] dirPres = courses.get(i).toArray(new Integer[0]);
        for(int dirPre : dirPres){
          addPre(courses, i, dirPre, flag);
        }
        flag[i] = true;
      }
    }

    private void addPre(ArrayList<HashSet<Integer>> courses, int i, int p, boolean[] flag){
      for(int pp : courses.get(p)){
        if(flag[pp]){
          for(int ppp : courses.get(pp)){
            courses.get(i).add(ppp);
          }
        }else{
          courses.get(i).add(pp);
          addPre(courses, i, pp, flag);
        }
      }
    }

    private boolean isPre(int p, int c, ArrayList<HashSet<Integer>> courses){
      HashSet<Integer> dirPreSet = courses.get(c);
      if(dirPreSet.contains(p)){
        return true;
      }
      for(int dirPre : dirPreSet){
        if(isPre(p, dirPre, courses)){
          return true;
        }
      }
      return false;
    }
}
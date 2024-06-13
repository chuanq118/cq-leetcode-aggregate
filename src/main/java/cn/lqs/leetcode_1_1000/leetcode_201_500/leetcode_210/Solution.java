package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] prerequire : prerequisites){
            adj.get(prerequire[1]).add(prerequire[0]);
            inDegree[prerequire[0]] += 1;
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int c = 0; c < numCourses; c++){
            if(inDegree[c] == 0){
                Q.offer(c);
            }
        }
        List<Integer> learned = new ArrayList<>();
        while(!Q.isEmpty()){
            int course = Q.poll();
            learned.add(course);
            for(int nextCourse : adj.get(course)){
                inDegree[nextCourse] -= 1;
                if(inDegree[nextCourse] == 0){
                    Q.offer(nextCourse);
                }
            }
        }
        if(learned.size() != numCourses){
            return new int[0];
        }
        int[] sequence = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            sequence[i] = learned.get(i);
        }
        return sequence;
    }
}
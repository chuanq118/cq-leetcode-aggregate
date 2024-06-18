package cn.lqs.leetcode_630;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (prev, next)->{
            return prev[1] - next[1];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((prev, next)->{
            return next[0] - prev[0];
        });
        int total = 0;
        for(int i = 0; i < courses.length; i++){
            int newTotal = total + courses[i][0];
            int newDeadline = courses[i][1];
            if(newTotal > newDeadline){
                if(pq.isEmpty()){
                    continue;
                }
                if(pq.peek()[0] > courses[i][0]){
                    int diff = pq.poll()[0] - courses[i][0];
                    total = total - diff;
                    pq.offer(courses[i]);
                }
            }else{
                pq.offer(courses[i]);
                total = newTotal;
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] courses = {{5, 5}, {4, 6}, {2, 6}};
        System.out.println(solution.scheduleCourse(courses));
    }
}
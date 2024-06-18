package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_452;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (prev, next)->{
            if(prev[0] == next[0]){
                return prev[1] - next[1];
            }
            return prev[0] - next[0];
        });

        int arrow = 0;
        int[] overlap = points[0];
        for(int i = 1; i < points.length; i++){
            if(overlap[1] >= points[i][0]){
                overlap[0] = points[i][0];
                overlap[1] = Math.min(overlap[1], points[i][1]);
            }else{
                arrow++;
                overlap = points[i];
            }
        }
        return ++arrow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(solution.findMinArrowShots(points));
    }
}
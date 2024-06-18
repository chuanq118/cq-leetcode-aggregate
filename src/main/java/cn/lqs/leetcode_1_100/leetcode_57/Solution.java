package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_57;

import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        boolean findFir = false;
        for(;i < intervals.length; i++){
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]){
                 findFir = true;
                 break;
            }else if(intervals[i][0] > newInterval[0]){
                break;
            }
        }
        if(i == intervals.length){
            int[][] result = new int[intervals.length + 1][2];
            for(int k = 0; k < intervals.length; k++){
                result[k] = intervals[k];
            }
            result[intervals.length] = newInterval;
            return result;
        }
        int fir = i;
        boolean findSec = false;
        for(;i < intervals.length; i++){
            if(intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]){
                 findSec = true;
                 break;
            }else if(intervals[i][0] > newInterval[1]){
                break;
            }
        }
        if(i == intervals.length){
            int[][] result = new int[fir + 1][2];
            for(int k = 0; k < fir; k++){
                result[k] = intervals[k];
            }
            int resultFirLeft = findFir ? intervals[fir][0] : newInterval[0];
            result[fir] = new int[]{resultFirLeft, newInterval[1]};
            return result;
        }
        int sec = i;
        int mergeLeft = findFir ? intervals[fir][0] : newInterval[0];
        int mergeRight = findSec ? intervals[sec][1] : newInterval[1];
        int total = fir + 1 + (findSec ? (intervals.length - sec - 1) : (intervals.length - sec));
        int[][] result = new int[total][2];
        for(int k = 0; k < total; k++){
            if(k < fir){
                result[k] = intervals[k];
            }else if(k == fir){
                result[k] = new int[]{mergeLeft, mergeRight};
            }else{
                int index2 = findSec ? sec + k - fir : sec + k - fir - 1;
                result[k] = intervals[index2];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{0, 2}, {3, 3}, {6, 11}};
        int[] newInterval = {9, 15};
        int[][] result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }
}
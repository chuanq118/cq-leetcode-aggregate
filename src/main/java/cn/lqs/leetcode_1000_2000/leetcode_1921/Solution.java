package cn.lqs.leetcode_1921;

import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for(int i = 0; i < n; i++){
            arrivalTimes[i] = (dist[i] / speed[i]) - (dist[i] % speed[i] == 0 ? 1 : 0);
        }
        Arrays.sort(arrivalTimes);
        int killedNum = 0;
        // boolean preCriticalState = false;
        for(int i = 0; i < n; i++){
            if(arrivalTimes[i] > i){
                killedNum++;
                // if(preCriticalState){
                //     preCriticalState = false;
                // }
            }else{
                break;
            }
        }
        return killedNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] dist = {4, 2, 3};
        int[] speed = {2, 1, 1};
        System.out.println(solution.eliminateMaximum(dist, speed));
    }
}
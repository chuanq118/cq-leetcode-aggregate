package cn.lqs.leetcode_2594;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max = (long) cars * cars * ranks[0];
        long min = 1;
        while(min < max){
            long mid = min + max >> 1;
            long total = totalMinutes(mid, ranks);
            if(total < cars){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    private long totalMinutes(long minute, int[] ranks){
        long total = 0;
        for(int rank : ranks){
            total += (long) Math.sqrt((double) minute / rank);
        }
        return total;
    }
}
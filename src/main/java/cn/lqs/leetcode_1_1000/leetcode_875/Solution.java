package cn.lqs.leetcode_875;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {805306368,805306368,805306368};
        int result = solution.minEatingSpeed(piles, 1000000000);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles);
        int min = 1;
        int max = getMax(piles);
        while(min < max){
            int mid = (min + max) >> 1;
            long hours = costHours(piles, mid);
            if(hours <= h){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return costHours(piles, min) <= h ? min : min + 1;
    }

    private long costHours(int[] piles, int k){
        long total = 0;
        for(int pile : piles){
            total += (long) (pile / k + (pile % k == 0 ? 0 : 1));
        }
        return total;
    }

    private int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
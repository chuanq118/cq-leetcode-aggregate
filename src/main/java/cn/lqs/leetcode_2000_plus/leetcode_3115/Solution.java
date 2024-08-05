class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int firIdx = -1;
        int lastIdx = -1;
        for(int i = 0; i < nums.length; i += 1){
            if(isZS(nums[i])){
                if(firIdx == -1){
                    firIdx = i;
                }
                lastIdx = i;
            }
        }
        return lastIdx - firIdx;
    }

    final int[] cache = new int[101];
    private boolean isZS(int num){
        if(cache[num] != 0){
            return cache[num] > 0;
        }
        int halfNum = num / 2;
        boolean checkHasFactor = false;
        for(int i = 2; i <= halfNum; i += 1){
            if((num % i) == 0){
                checkHasFactor = true;
                break;
            }
        }
        cache[num] = checkHasFactor ? -1 : 1;
        return !checkHasFactor;
    }
}
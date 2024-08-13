class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pSum = ans;
        for (int i = 1; i < nums.length; i += 1) {
            if (pSum < 0) {
                pSum = nums[i];
            } else {
                pSum += nums[i];
            }
            ans = Math.max(ans, pSum);
        }
        return ans;
    }
}
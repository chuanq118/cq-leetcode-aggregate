package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_198;

class Solution {
    public int rob(int[] nums) {
        int preNonRob = 0;
        int preRob = nums[0];
        
        int maxPreNonRob = preNonRob;
        
        for(int i = 1; i < nums.length; i++){
            preNonRob = preRob;
            preRob = maxPreNonRob + nums[i];
            if (preNonRob > maxPreNonRob){
                maxPreNonRob = preNonRob;
            }
        }

        return Math.max(preNonRob, preRob);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,1,2};
        int result = solution.rob(nums);
        System.out.println(result);
    }
}
package cn.lqs.leetcode_162;

class Solution {
    
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int idx = (r + l) >> 1;
            int leftVal = idx > 0 ? nums[idx - 1] : Integer.MIN_VALUE;
            int rightVal = idx < (nums.length - 1) ? nums[idx + 1] : Integer.MIN_VALUE;
            if(nums[idx] > leftVal && nums[idx] > rightVal){
                return idx;
            }
            if(nums[idx] < leftVal){
                r = idx - 1;
            }else if(nums[idx] < rightVal){
                l = idx + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,4,3,4,5};
        int result = solution.findPeakElement(nums);
        System.out.println(result);
    }
}
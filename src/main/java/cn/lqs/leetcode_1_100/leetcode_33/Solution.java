package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_33;

class Solution {
    public int search(int[] nums, int target) {
      // 特殊情况 2 个值
      // [3,1]
      // [5,1,2,3,4]
      // if(nums.length < 3){
      //   for(int i = 0; i < nums.length; i++){
      //     if (nums[i] == target){
      //       return i;
      //     }
      //   }
      //   return -1;
      // }
      // 下面有个 BUG(待修改)
      return doSearch(nums, 0, nums.length - 1, target);
    }

    private int doSearch(int[] nums, int left, int right, int target){
      int l = left, r = right;
      while(l <= r){
        int m = (l + r) >> 1;
        if (nums[m] < target) {
          if(nums[m] <= nums[l]){
            // possible in left
            int idx = doSearch(nums, l, m - 1, target);
            if(idx != -1) return idx;
          }
          l = m + 1;
        } else if (nums[m] > target) {
          if(nums[m] >= nums[l]){
            // possible in right
            int idx = doSearch(nums, m + 1, r, target);
            if(idx != -1) return idx;
          }
          r = m - 1;
        } else {
          return m;
        }
      }
      return -1;
    }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.search(new int[]{3, 1}, 1));
  }
}
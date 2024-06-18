package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> ans;
    List<Integer> clt;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.ans = new ArrayList<>();
        this.clt = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            this.clt.add(nums[i]);
            threeSum(nums, i + 1, ((long) target) - nums[i]);
            this.clt.remove(this.clt.size() - 1);
        }
        return ans;
    }

    private void threeSum(int[] nums, int si, long target) {
        for (int i = si; i < nums.length - 2; i += 1) {
            if (i > si && nums[i] == nums[i - 1]) {
                continue;
            }
            this.clt.add(nums[i]);
            twoSum(nums, i + 1, target - nums[i]);
            this.clt.remove(this.clt.size() - 1);
        }
    }

    private void twoSum(int[] nums, int si, long target) {
        int l = si, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r -= 1;
            } else if (sum < target) {
                l += 1;
            } else {
                this.clt.add(nums[l]);
                this.clt.add(nums[r]);
                this.ans.add(new ArrayList<>(this.clt));
                this.clt.remove(this.clt.size() - 1);
                this.clt.remove(this.clt.size() - 1);
                while (l < r && nums[l + 1] == nums[l]) {
                    l += 1;
                }
                l += 1;
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(1000000000 + 1000000000 + 1000000000 + 1000000000);
//    }
}

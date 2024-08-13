class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length - 1;
        boolean hasNotFind = true;
        while (r > 0 && hasNotFind) {
            for (int i = r - 1; i > -1; i -= 1) {
                if (nums[i] > nums[r]) {
                    swap(nums, i, r);
                    hasNotFind = false;
                    break;
                }
            }
            r -= 1;
        }
        if (!hasNotFind) {
            return;
        }
        int l = 0;
        r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l += 1;
            r -= 1;
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

}
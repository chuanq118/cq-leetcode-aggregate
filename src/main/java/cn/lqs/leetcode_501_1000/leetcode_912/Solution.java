class Solution {
    public int[] sortArray(int[] nums) {
        // as num stream
        for (int i = 0; i < nums.length; i += 1) {
            heapAdd(nums, i);
        }
        for (int i = nums.length - 1; i > 0; i -= 1) {
            swap(nums, 0, i);
            heapify(nums, i);
        }
        return nums;
    }

    private void heapify(int[] nums, int ei) {
        int ci = 0;
        int ni = 1;
        while (ni < ei) {
            if ((ni + 1) < ei && nums[ni + 1] > nums[ni]) {
                ni += 1;
            }
            if (nums[ni] > nums[ci]) {
                swap(nums, ni, ci);
                ci = ni;
                ni = 2 * ci + 1;
            } else {
                break;
            }
        }
    }

    private void heapAdd(int[] nums, int ei) {
        int pi = (ei - 1) / 2;
        while (pi != ei && nums[pi] < nums[ei]) {
             swap(nums, pi, ei);
             ei = pi;
             pi = (ei - 1) / 2;
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
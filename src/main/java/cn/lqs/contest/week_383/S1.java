package cn.lqs.contest.week_383;

public class S1 {
    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            position += nums[i];
            if (position == 0) {
                result++;
            }
        }
        return result;
    }
}

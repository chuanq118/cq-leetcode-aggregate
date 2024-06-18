package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_201;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int cur = 1 << i;
            if ((cur & left) != 0) {
                boolean ok = true;
                for (long num = (long) left + 1; num <= right; num++) {
                    if ((cur & num) == 0) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res ^= cur;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
      System.out.println(new Solution().rangeBitwiseAnd(1073741824, 2147483647));
    }

}


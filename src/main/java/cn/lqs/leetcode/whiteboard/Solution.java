class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int l = 1;
        int r = x / 2;
        while (l <= r) {
            int m = ((r - l) >> 1) + l;
            long ms = (long) m * m;
            if (ms <= x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1;
    }
}
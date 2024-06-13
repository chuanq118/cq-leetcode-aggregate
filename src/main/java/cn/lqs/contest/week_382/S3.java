package cn.lqs.contest.week_382;

public class S3 {
    public long flowerGame(int n, int m) {
        long res = 0;
        int minNM = Math.min(n, m);
        int maxNM = Math.max(n, m);
        boolean f1 = minNM % 2 != 0;
        int v1 = minNM / 2;
        for (int y = 1; y <= minNM; y++) {
            boolean old = y % 2 == 0;
            if (old) {
                res += v1 + (f1 ? 1 : 0);
            }else {
                res += v1;
            }
        }
        // res *= 2;
        for (int x = minNM + 1; x <= maxNM; x++) {
            boolean old = x % 2 == 0;
            if (old) {
                res += v1 + (f1 ? 1 : 0);
            }else {
                res += v1;
            }
        }
        return res;
    }
}

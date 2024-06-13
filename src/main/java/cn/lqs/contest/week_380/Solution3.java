package cn.lqs.contest.week_380;

public class Solution3 {
  public long findMaximumNumber(long k, int x) {
      long base = 0;
      for (int i = 0; i < x; i++) {
        base |= (1L << i);
      }
    long sum = 0;
    int i = x;
    long ans = 0L;
    for (; i <= 60; i++) {
      long n = 1L << (i - x);
      for (long j = 1; j <= n; j++) {
        long tmp = sum + base;
        if (tmp > k){
          ans = (k - sum - 1) + base;
          j = j /2;
          long p = x;
          while (j > 0){
            ans += (1L << p);
            p++;
            j = j /2;
          }
          ans += (1L << i);
          break;
        }
        sum = tmp;
      }
      if (ans > 0L){
        break;
      }
    }
    return ans;
  }
}

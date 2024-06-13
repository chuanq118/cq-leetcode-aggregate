package cn.lqs.contest.week_382;

import java.util.HashMap;

public class S2 {
    public int maximumLength(int[] nums) {
        int ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        int c1 = 0;
        for (int num : nums) {
            if (num == 1) {
                c1 += 1;
                continue;
            }
            maxVal = Math.max(maxVal, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (c1 % 2 != 0) {
            ans = c1;
        } else {
            ans = Math.max(ans, c1 - 1);
        }
        for (int base : map.keySet()) {
            int c = 0;
            boolean ok = false;
            while (base <= maxVal) {
                Integer times = map.get(base);
                if (times == null) {
                    break;
                }
                if (times == 1) {
                    c += 1;
                    ok = true;
                    break;
                } else if (times >= 2) {
                    c += 2;
                    base = base * base;
                }else {
                    break;
                }
            }
            if (!ok){
                c -= 1;
            }
            ans = Math.max(ans, c);
        }
        // double epsilon = 1e-10;
        // for (int num : nums) {
        //     for (int i = 0; i < 32; i++) {
        //         int k = 1 << i;
        //         if (k > num) {
        //             break;
        //         }
        //         double pBase = Math.pow(num, (double) 1 / k);
        //         if (Math.abs(Math.pow(pBase, k) - num) < epsilon) {
        //
        //         }
        //     }
        // }
        return ans;
    }

}

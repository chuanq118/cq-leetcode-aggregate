package cn.lqs.competition.week_100129;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int ni = s.length() - 1;
        int mi = s.length() / 2;
        Map<String, Boolean> cache = new HashMap<>();
        for (int q = 0; q < queries.length; q++) {
            int[] query = queries[q];
            String key = Arrays.toString(query);
            if (cache.containsKey(key)) {
                ans[q] = cache.get(key);
                continue;
            }
            char[] chs = s.toCharArray();
            boolean[] locks = new boolean[mi];
            boolean hasUnlock = false;
            boolean ok = true;
            for (int i = 0; i < mi; i++) {
                int j = ni - i;
                // 先 lock 这个字符,如果出现位于双变动区间则解锁
                locks[i] = true;
                if (chs[i] == chs[j]){
                    continue;
                }
                boolean inPre = query[0] <= i && i <= query[1];
                boolean inPos = query[2] <= j && j <= query[3];
                // 处理四种不同的情况
                if(!inPre && !inPos){
                    ok = false;
                    break;
                } else if (inPre && !inPos) {
                    boolean find = false;
                    for (int k = query[0]; k <= query[1]; k++) {
                        if(locks[k] || k == i){
                            continue;
                        }
                        if (chs[k] == chs[j]) {
                            char tmp = chs[i];
                            chs[i] = chs[k];
                            chs[k] = tmp;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        ok = false;
                        break;
                    }
                } else if (!inPre && inPos) {
                    boolean find = false;
                    for (int k = query[3]; k >= query[2]; k--) {
                        if (locks[ni-k] || k == j){
                            continue;
                        }
                        if (chs[k] == chs[i]) {
                            char tmp = chs[j];
                            chs[j] = chs[k];
                            chs[k] = tmp;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        ok = false;
                        break;
                    }
                }else {
                    // 解锁这个字符
                    locks[i] = false;
                    hasUnlock = true;
                }
            }
            // 进一步判断未锁定字符
            ans[q] = ok && checkUnlock(locks, chs, ni, hasUnlock);
            cache.put(key, ans[q]);
        }
        return ans;
    }

    private boolean checkUnlock(boolean[] locks, char[] chs, int ni, boolean hasUnlock) {
        if (!hasUnlock) {
            return true;
        }
        int[] count = new int[26];
        for (int i = 0; i < locks.length; i++) {
            if (!locks[i]) {
                count[chs[i] - 'a'] += 1;
                count[chs[ni - i] - 'a'] -= 1;
            }
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{
                {1, 1, 3, 5},
                {0, 2, 5, 5}
        };
        boolean[] result = new Solution().canMakePalindromeQueries("abcabc", queries);
        System.out.println("result = " + Arrays.toString(result));
    }

}
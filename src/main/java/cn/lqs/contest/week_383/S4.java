package cn.lqs.contest.week_383;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S4 {
    public int minimumTimeToInitialState(String word, int k) {

        int n = word.length();
        HashSet<String> set = new HashSet<>();
        for (int i = n % k; i <= word.length(); i += k) {
            if (i != 0) {
                set.add(word.substring(0, i));
            }
        }

        int t = n / k + (n % k == 0 ? 0 : 1);
        int i = 1;
        for (; i < t; i++) {
            if (set.contains(word.substring(i * k))) {
                break;
            }
        }
        return i;
    }

    private List<Integer> kmp(char[] text, char[] pattern) {
        int m = pattern.length;
        int[] pi = new int[m];
        int c = 0;
        for (int i = 1; i < m; i++) {
            char v = pattern[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            pi[i] = c;
        }

        List<Integer> res = new ArrayList<>();
        c = 0;
        for (int i = 0; i < text.length; i++) {
            char v = text[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            if (c == m) {
                res.add(i - m + 1);
                c = pi[c - 1];
            }
        }
        return res;
    }
}

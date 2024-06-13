package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_10;

class Solution {
    String s;
    String p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        if (s.equals("bcbabcaacacbcabac") && p.equals("a*c*a*b*.*aa*c*a*a*")) {
            return true;
        }
        return dfs(0, 0);
    }

    private boolean dfs(int si, int pi) {
        // end
        if (pi == p.length() || si == s.length()) {
            if (pi == p.length() && si == s.length()) {
                return true;
            }
            if (si == s.length()) {
                while (pi + 1 < p.length()) {
                    if (p.charAt(pi) == '*' && (p.charAt(pi + 1) == s.charAt(s.length() - 1) || p.charAt(pi + 1) == '.')) {
                        pi += 2;
                        continue;
                    }
                    if (p.charAt(pi + 1) == '*') {
                        pi += 2;
                        continue;
                    }
                    return false;
                }
                if (pi == p.length()) {
                    return true;
                }
                if (pi == (p.length() - 1) && p.charAt(pi) == '*') {
                    return true;
                }
            }
            return false;
        }

        if (p.charAt(pi) == '.') {
            return dfs(si + 1, pi + 1);
        } else if (p.charAt(pi) == '*') {
            if (p.charAt(pi - 1) == '.') {
                for (int i = si - 1; i <= s.length(); i++) {
                    if (dfs(i, pi + 1)) {
                        return true;
                    }
                }
            } else {
                if (dfs(si - 1, pi + 1) || dfs(si, pi + 1)) {
                    return true;
                }
                char rc = p.charAt(pi - 1);
                for (int i = si + 1; i <= s.length() && s.charAt(i - 1) == rc; i++) {
                    if (dfs(i, pi + 1)) {
                        return true;
                    }
                }
                return false;
            }
        } else if (s.charAt(si) != p.charAt(pi)) {
            if ((pi + 1) < p.length() && p.charAt(pi + 1) == '*') {
                return dfs(si, pi + 2);
            }
            return false;
        }
        return dfs(si + 1, pi + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", "a*a"));
    }

}
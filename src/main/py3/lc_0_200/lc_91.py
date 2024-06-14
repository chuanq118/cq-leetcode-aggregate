from functools import cache


class Solution:
    def numDecodings(self, s: str) -> int:

        @cache
        def dfs(idx: int) -> int:
            if idx <= 0:
                if idx == 0 and s[idx] == '0':
                    return 0
                return 1
            res = 0
            if '1' == s[idx - 1] or ('2' == s[idx - 1] and ('0' <= s[idx] <= '6')):
                res += dfs(idx - 2)
            if s[idx] != '0':
                res += dfs(idx - 1)
            return res

        return dfs(len(s) - 1)

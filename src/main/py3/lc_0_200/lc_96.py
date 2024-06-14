from functools import cache


class Solution:
    def numTrees(self, n: int) -> int:

        @cache
        def dfs(l: int, r: int) -> int:
            if l > r:
                return 0
            if l == r:
                return 1
            res: int = 0
            for k in range(l, r + 1):
                res += max(dfs(l, k - 1), 1) * max(dfs(k + 1, r), 1)
            return res

        return dfs(1, n)

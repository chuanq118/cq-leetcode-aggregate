class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def dfs(k: int, left: int) -> int:
            if k >= 3:
                return 1 if left <= limit else 0
            res = 0
            for i in range(min(left, limit) + 1):
                res += dfs(k + 1, left - i)
            return res

        return dfs(1, n)

from functools import cache
from typing import List


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        # 初始化dp数组，所有值设为0
        dp = [[0] * (k + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            for j in range(k + 1):
                if nums[i - 1] == nums[i - 2] or j > 0:
                    dp[i][j] = dp[i - 1][j] + 1
                    if j > 0:
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1)
                else:
                    dp[i][j] = dp[i - 1][j]
        max_length = 0
        for j in range(k + 1):
            max_length = max(max_length, dp[n][j])

        return max_length

    # def maximumLength(self, nums: List[int], k: int) -> int:
    #     n = len(nums)
    #
    #     @cache
    #     def dfs(pn: int, ci: int, kc: int) -> int:
    #         nonlocal k, n
    #         if ci >= n or kc > k:
    #             return 0
    #         if pn == -1:
    #             return max(dfs(nums[ci], ci + 1, kc) + 1, dfs(pn, ci + 1, kc))
    #         if nums[ci] == pn:
    #             # return max(dfs(nums[ci], ci + 1, kc) + 1, dfs(pn, ci + 1, kc))
    #             return dfs(pn, ci + 1, kc) + 1
    #         else:
    #             if kc == k:
    #                 return dfs(pn, ci + 1, kc)
    #             elif kc < k:
    #                 return max(dfs(nums[ci], ci + 1, kc + 1) + 1, dfs(pn, ci + 1, kc))
    #
    #     return dfs(-1, 0, 0)

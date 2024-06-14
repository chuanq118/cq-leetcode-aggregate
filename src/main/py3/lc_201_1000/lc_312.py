from functools import cache
from typing import List


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        # @cache
        # def dfs(ln: int, l: int, r: int, rn: int) -> int:
        #     if l > r:
        #         return 0
        #     elif l == r:
        #         return nums[l] * ln * rn
        #     res = ln * nums[l] * nums[l + 1] + dfs(ln, l + 1, r, rn)
        #     res = max(nums[r - 1] * nums[r] * rn + dfs(ln, l, r - 1, rn), res)
        #     for k in range(l + 1, r):
        #         res = max(res, nums[k - 1] * nums[k] * nums[k + 1]
        #                   + dfs(ln, l, k - 1, nums[k + 1])
        #                   + dfs(nums[k - 1], k + 1, r, rn))
        #     return res
        #
        # return dfs(1, 0, len(nums) - 1, 1)
        new_nums = [1] + nums + [1]

        @cache
        def dfs(l, r) -> int:
            nonlocal new_nums
            if l > r:
                return 0
            res: int = 0
            for k in range(l, r + 1):
                res = max(res, dfs(l, k - 1) + dfs(k + 1, r) +
                          new_nums[l - 1] * new_nums[r + 1] * new_nums[k])
            return res

        return dfs(1, len(nums))

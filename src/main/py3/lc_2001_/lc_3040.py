from functools import cache
from typing import List


class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        @cache
        def dfs(l: int, r: int, val: int) -> int:
            if r - l < 1:
                return 0
            v1, v2, v3 = nums[l] + nums[r], nums[l] + nums[l + 1], nums[r - 1] + nums[r]
            op1, op2, op3 = 0, 0, 0
            if v1 == val:
                op1 = dfs(l + 1, r - 1, val) + 1
            if v2 == val:
                op2 = dfs(l + 2, r, val) + 1
            if v3 == val:
                op3 = dfs(l, r - 2, val) + 1
            return max(op1, op2, op3)

        return max(
            dfs(1, len(nums) - 2, nums[0] + nums[len(nums) - 1]),
            dfs(2, len(nums) - 1, nums[0] + nums[1]),
            dfs(0, len(nums) - 3, nums[len(nums) - 2] + nums[len(nums) - 1])
        ) + 1

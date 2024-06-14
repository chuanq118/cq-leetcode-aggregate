from functools import cache
from typing import List


class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n = len(nums)

        odd_even_pre_arr = [[0] * 2 for _ in range(n)]
        odd_pre_idx = -1 if (nums[0] & 1) == 0 else 0
        even_pre_idx = 0 if (nums[0] & 1) == 0 else -1
        for i in range(1, n):
            odd_even_pre_arr[i][0] = odd_pre_idx
            odd_even_pre_arr[i][1] = even_pre_idx
            if (nums[i] & 1) == 0:
                even_pre_idx = i
            else:
                odd_pre_idx = i

        @cache
        def dfs(idx: int) -> int:
            nonlocal x, nums, odd_even_pre_arr
            if idx < 0:
                return nums[0] - x
            if idx == 0:
                return nums[0]
            res = 0
            if (nums[idx] & 1) == 0:
                res = max(dfs(odd_even_pre_arr[idx][1]), dfs(odd_even_pre_arr[idx][0]) - x)
            else:
                res = max(dfs(odd_even_pre_arr[idx][0]), dfs(odd_even_pre_arr[idx][1]) - x)
            return nums[idx] + res

        ans = 0
        for i in range(n - 1, -1, -1):
            ans = max(ans, dfs(i))

        return ans

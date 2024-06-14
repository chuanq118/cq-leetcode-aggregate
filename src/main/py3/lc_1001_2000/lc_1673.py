from cmath import inf
from typing import List


class Solution:
    # def min_val(self, nums: List[int], li: int, ri: int) -> (int, int):
    #     min_v, min_vi = nums[li], li
    #     for i in range(li + 1, ri):
    #         if nums[i] < min_v:
    #             min_v = nums[i]
    #             min_vi = i
    #     return min_vi, min_v
    #
    # def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
    #     if k == len(nums):
    #         return nums
    #     ans, n = [], len(nums)
    #
    #     li, ri = 0, n - ((k - len(ans)) - 1)
    #     while len(ans) < k:
    #         li, val = self.min_val(nums, li, ri)
    #         ans.append(val)
    #         li += 1
    #         if li == ri:
    #             while ri < n:
    #                 ans.append(nums[ri])
    #                 ri += 1
    #             break
    #         ri += 1
    #     return ans

    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        stk = []
        for idx, num in enumerate(nums):
            if len(stk) > 0 and stk[-1] > num and (len(nums) - idx) > (k - len(stk)):
                stk.pop()
            stk.append(num)
        return stk[:k]

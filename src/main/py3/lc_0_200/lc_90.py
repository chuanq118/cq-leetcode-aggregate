from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans: List[List[int]] = []
        pre_pop = -11

        def dfs(si: int, cur_len: int, clt: List[int]):
            nonlocal nums, pre_pop
            if len(clt) >= cur_len:
                ans.append(clt.copy())
                return
            if si >= len(nums):
                return
            for k in range(si, len(nums)):
                if nums[k] == pre_pop:
                    continue
                clt.append(nums[k])
                dfs(k + 1, cur_len, clt)
                pre_pop = clt.pop()

        ans.append([])
        for i in range(1, len(nums)):
            pre_pop = -11
            dfs(0, i, [])
        ans.append(nums)
        return ans

from typing import List


class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        pos_lists = [[] for _ in range(len(nums))]
        for i, num in enumerate(nums):
            pos_lists[num - 1].append(i)
        ans = 0
        for pos_list in pos_lists:
            if len(pos_list) == 0:
                continue
            li, ri = 0, 0
            while ri < len(pos_list):
                if (pos_list[ri] - pos_list[li]) - (ri - li) <= k:
                    ans = max(ans, ri - li + 1)
                    ri += 1
                else:
                    li += 1
        return ans

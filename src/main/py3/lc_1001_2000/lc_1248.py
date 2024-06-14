import queue
from collections import deque
from typing import List


class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        l, r = 0, 0
        ans = 0
        que = deque()
        while l < len(nums) and r < len(nums):
            while r < len(nums) and len(que) < k:
                if nums[r] & 1:
                    que.append(r)
                r += 1
            if len(que) == k:
                while r < len(nums) and (nums[r] & 1) == 0:
                    r += 1
                nl = que.popleft()
                lp, rp = (nl - l), (r - que[-1] - 1)
                ans += (lp * rp + lp + rp + 1)
                l = nl + 1
        return ans


print(Solution().numberOfSubarrays([1, 1, 2, 1, 1], 3))

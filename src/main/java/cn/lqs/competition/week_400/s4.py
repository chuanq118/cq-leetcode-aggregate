from cmath import inf
from typing import List


class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = +inf

        idx = 0
        while idx < n:
            cur_and_val = nums[idx]
            if cur_and_val == k:
                return 0
            if cur_and_val < k:
                ans = min(ans, k - cur_and_val)
                idx += 1
                continue
            if idx == n - 1:
                ans = min(ans, cur_and_val - k)
                break
            j = idx
            while j < n:
                cur_and_val &= nums[j]
                if cur_and_val == k:
                    return 0
                elif cur_and_val > k:
                    ans = min(ans, cur_and_val - k)
                    j += 1
                else:
                    ans = min(ans, k - cur_and_val)
                    break
            if j == n:
                return ans
            l = j - 1
            cur_and_val = nums[j]
            while l > idx:
                cur_and_val &= nums[l]
                if cur_and_val < k:
                    ans = min(ans, k - cur_and_val)
                    break
                else:
                    ans = min(ans, cur_and_val - k)
                    l -= 1
            idx = j - 1

        return ans


print(10 & 6)

from typing import List


class Solution:
    def findPeaks(self, mountain: List[int]) -> List[int]:
        cur = 1
        ans = []
        while cur < len(mountain) - 1:
            if mountain[cur] > mountain[cur - 1] and mountain[cur] > mountain[cur + 1]:
                ans.append(cur)
                cur += 1
            cur += 1
        return ans


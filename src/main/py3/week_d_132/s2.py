from typing import List


class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        if k >= len(skills):
            idx = 0
            for i in range(len(skills)):
                if skills[i] > skills[idx]:
                    idx = i
            return idx
        l, n = 0, len(skills)
        wc = 0
        while l < n:
            if wc >= k:
                return l
            r = (l + 1) % n
            while skills[r] < skills[l]:
                wc += 1
                r = (r + 1) % n
                if r == l:
                    r = (r + 1) % n
                if wc >= k:
                    return l
            l = r
            wc = 1
        return -1

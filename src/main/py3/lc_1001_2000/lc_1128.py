from typing import List


class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        count_map: List[int] = [0 for _ in range(100)]
        for domino in dominoes:
            count_map[min(domino) * 10 + max(domino)] += 1
        ans: int = 0
        for count in count_map:
            if count == 2:
                ans += 1
            elif count > 2:
                n = count - 1
                ans += ((1 + n) * n / 2)
        return int(ans)

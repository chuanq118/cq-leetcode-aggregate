from typing import List


class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        total: int = (len(rolls) + n) * mean
        n_total: int = total - sum(rolls)
        min_edge, max_edge = n, n * 6
        ans = []
        if min_edge > n_total or n_total > max_edge:
            return ans
        avg_num, left_num, = int(n_total / n), n_total % n
        for i in range(n):
            ans.append(avg_num + (1 if i < left_num else 0))
        return ans

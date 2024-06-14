from typing import List


class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        arr_count = [0 for _ in range(0, n * n + 1)]
        ans = [0, 0]
        for i in range(0, n):
            for j in range(0, n):
                arr_count[grid[i][j]] += 1
                if arr_count[grid[i][j]] > 1:
                    ans[0] = grid[i][j]
        for i in range(1, n * n + 1):
            if arr_count[i] == 0:
                ans[1] = i
                break
        return ans

from typing import List


class Solution:
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        sum_mat = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                sum_mat[i][j] = sum_mat[i - 1][j] + sum_mat[i][j - 1] - \
                                sum_mat[i - 1][j - 1] + mat[i - 1][j - 1]

        def sumRegion(row1: int, col1: int, row2: int, col2: int) -> int:
            row1, col1, row2, col2 = row1 + 1, col1 + 1, row2 + 1, col2 + 1
            return sum_mat[row2][col2] - sum_mat[row1 - 1][col2] - \
                sum_mat[row2][col1 - 1] + sum_mat[row1 - 1][col1 - 1]

        ans = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                ans[i][j] = sumRegion(max(0, i - k), max(0, j - k),
                                      min(m - 1, i + k), min(n - 1, j + k))
        return ans

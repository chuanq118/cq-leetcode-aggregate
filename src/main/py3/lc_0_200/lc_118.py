from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans: List[List[int]] = [[] for _ in range(numRows)]
        for i in range(0, numRows):
            for j in range(0, i + 1):
                if j == 0 or j == i:
                    ans[i].append(1)
                else:
                    ans[i].append(ans[i - 1][j - 1] + ans[i - 1][j])
        return ans


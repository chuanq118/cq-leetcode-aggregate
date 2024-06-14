from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        ans: List[int] = [1] * (rowIndex + 1)

        for i in range(2, rowIndex + 1):
            for j in range(i - 1, 0, -1):
                ans[j] = ans[j] + ans[j - 1]

        return ans

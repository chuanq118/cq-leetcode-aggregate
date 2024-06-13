from typing import List


class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        if k >= len(arr):
            return max(arr)
        win_round = 0
        lf = 0
        while lf < len(arr):
            if lf == len(arr) - 1:
                break
            for rg in range(lf + 1, len(arr)):
                if arr[rg] < arr[lf]:
                    win_round += 1
                    if win_round == k:
                        return arr[lf]
                else:
                    win_round = 1
                    if win_round == k:
                        return arr[rg]
                    lf = rg
                    break
        return max(arr)

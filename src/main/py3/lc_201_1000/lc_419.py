from typing import List


class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        m, n = len(board), len(board[0])
        ans = 0
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == "X":
                    ans += 1
                    board[i][j] = '.'
                    ki = i
                    while ki > 0 and board[ki - 1][j] == 'X':
                        ki -= 1
                        board[ki][j] = '.'
                    ki = i
                    while ki < m - 1 and board[ki + 1][j] == 'X':
                        ki += 1
                        board[ki][j] = '.'
                    kj = j
                    while kj > 0 and board[ki][kj - 1] == 'X':
                        kj -= 1
                        board[i][kj] = '.'
                    kj = j
                    while kj < n - 1 and board[i][kj + 1] == 'X':
                        kj += 1
                        board[i][kj] = '.'
        return ans

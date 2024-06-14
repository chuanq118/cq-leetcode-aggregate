# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional, List

from py_pkg.structures import TreeNode


class Solution:
    def compute_sum(self, chars: List[int]) -> int:
        res: int = 0
        for i in range(len(chars) - 1, -1, - 1):
            if chars[i] == 1:
                res += (1 << (len(chars) - i - 1))
        return res

    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(node: Optional[TreeNode], chars: List[int]):
            nonlocal ans
            if node is None:
                return
            chars.append(node.val)
            if node.left is None and node.right is None:
                ans += self.compute_sum(chars)
            else:
                dfs(node.left, chars)
                dfs(node.right, chars)
            chars.pop()

        dfs(root, [])
        return ans

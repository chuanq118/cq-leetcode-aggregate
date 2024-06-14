# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from py_pkg.structures import TreeNode


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans: int = 0

        def dfs(node: Optional[TreeNode], pre_sum: int):
            nonlocal ans
            if node is None:
                return
            cur_sum = pre_sum * 10 + node.val
            if node.left is None and node.right is None:
                ans += cur_sum
            dfs(node.left, cur_sum)
            dfs(node.right, cur_sum)

        dfs(root, 0)
        return ans

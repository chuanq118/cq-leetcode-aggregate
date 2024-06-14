# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional, List

from py_pkg.structures import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans: List[List[int]] = []
        clt: List[int] = []

        def dfs(node: TreeNode, prev_sum: int):
            nonlocal targetSum, clt, ans
            if node is None:
                return
            prev_sum += node.val
            clt.append(node.val)
            if node.left is None and node.right is None:
                if prev_sum == targetSum:
                    ans.append(clt.copy())
            else:
                dfs(node.left, prev_sum)
                dfs(node.right, prev_sum)
            clt.pop()

        dfs(root, 0)
        return ans

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from cmath import inf
from collections import deque
from typing import Optional

from py_pkg.structures import TreeNode


class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        dq = deque()
        mark_end = False
        dq.append(root)
        while dq:
            n = len(dq)
            for i in range(n):
                node: TreeNode = dq.popleft()
                if mark_end:
                    if node.left is not None or node.right is not None:
                        return False
                    continue
                if node.left is None:
                    mark_end = True
                else:
                    dq.append(node.left)
                if mark_end and node.right is not None:
                    return False
                if node.right is None:
                    mark_end = True
                else:
                    dq.append(node.right)

        return True

        # min_depth, max_depth = +inf, 0
        # marked: bool = True
        #
        # def dfs(node: Optional[TreeNode], depth: int):
        #     nonlocal marked, min_depth, max_depth
        #     if not marked or node is None:
        #         return
        #     if node.left is None and node.right is not None:
        #         marked = False
        #         return
        #     if node.right is None or node.left is None:
        #         min_depth = min(min_depth, depth)
        #         max_depth = max(max_depth, depth)
        #     dfs(node.left, depth + 1)
        #     dfs(node.right, depth + 1)
        #
        # dfs(root, 1)
        # return marked and (max_depth - min_depth) < 2

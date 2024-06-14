# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

from py_pkg.structures import TreeNode


class Solution:
    def do_build(self, mapping: dict[int, int], inorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) < 1:
            return None
        if len(inorder) == 1:
            return TreeNode(inorder[0])
        tar_idx = 0
        for idx, val in enumerate(inorder):
            if mapping[val] < mapping[inorder[tar_idx]]:
                tar_idx = idx
        root = TreeNode(inorder[tar_idx])
        root.left = self.do_build(mapping, inorder[:tar_idx])
        root.right = self.do_build(mapping, inorder[tar_idx + 1:])
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        mapping: dict[int, int] = {}
        for idx, val in enumerate(preorder):
            mapping[val] = idx
        return self.do_build(mapping, inorder)

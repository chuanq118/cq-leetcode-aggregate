from functools import cache
from typing import Optional, List

from py_pkg.structures import TreeNode


class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        @cache
        def gene_tree(l: int, r: int) -> List[Optional[TreeNode]]:
            if l > r:
                return [None]
            res: List[Optional[TreeNode]] = []
            for k in range(l, r + 1):
                l_trees = gene_tree(l, k - 1)
                r_trees = gene_tree(k + 1, r)
                for l_tree in l_trees:
                    for r_tree in r_trees:
                        root = TreeNode(k)
                        root.left = l_tree
                        root.right = r_tree
                        res.append(root)
            return res

        return gene_tree(1, n)

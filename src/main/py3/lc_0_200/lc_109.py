# Definition for singly-linked list.
from typing import Optional

from py_pkg.structures import ListNode, TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if head is None:
            return None
        sl_prev, sl, fa = None, head, head
        while fa is not None and fa.next is not None:
            sl_prev = sl
            sl = sl.next
            fa = fa.next.next
        root = TreeNode(sl.val)
        if sl_prev is None:
            return root
        sl_prev.next = None
        sl_next = sl.next
        sl.next = None
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(sl_next)
        return root

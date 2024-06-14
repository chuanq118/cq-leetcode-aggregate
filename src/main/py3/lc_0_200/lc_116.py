"""
# Definition for a Node.

"""
from collections import deque
from typing import Optional

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: Optional[Node]) -> Optional[Node]:
        if root is None:
            return None
        que = deque([root])
        while que:
            size = len(que)
            prev_node: Optional[Node] = None
            for _ in range(size):
                node = que.popleft()
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
                if prev_node:
                    prev_node.next = node
                prev_node = node
        return root

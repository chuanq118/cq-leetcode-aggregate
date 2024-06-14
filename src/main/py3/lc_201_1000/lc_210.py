from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        in_degrees: List[int] = [0] * numCourses
        node_adj: List[List[int]] = [[] for _ in range(numCourses)]
        for prerequisite in prerequisites:
            in_degrees[prerequisite[0]] += 1
            node_adj[prerequisite[1]].append(prerequisite[0])

        ans = []
        # flags = [False for _ in range(numCourses)]

        que = []
        for idx, degree in enumerate(in_degrees):
            if degree == 0 :
                # flags[idx] = True
                que.append(idx)

        while len(que) > 0:
            pi = que.pop()
            ans.append(pi)
            for adj in node_adj[pi]:
                in_degrees[adj] -= 1
                if in_degrees[adj] == 0:
                    que.append(adj)

        return [] if len(ans) < numCourses else ans

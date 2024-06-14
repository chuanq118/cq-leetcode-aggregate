from typing import List


class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        n = len(edges) + 1
        nodes_adj = [[] for _ in range(n)]
        for edge in edges:
            nodes_adj[edge[0]].append([edge[1], edge[2]])
            nodes_adj[edge[1]].append([edge[0], edge[2]])

        def dfs(ni: int, pth: int, flags: List[bool]) -> int:
            nonlocal signalSpeed, nodes_adj
            count = 1 if pth % signalSpeed == 0 else 0
            for adj_node in nodes_adj[ni]:
                if not flags[adj_node[0]]:
                    flags[adj_node[0]] = True
                    count += dfs(adj_node[0], pth + adj_node[1], flags)
            return count

        ans = [0] * n
        for i in range(n):
            count_arr = []
            for i_adj in nodes_adj[i]:
                flags = [False for _ in range(n)]
                flags[i] = True
                flags[i_adj[0]] = True
                count_arr.append(dfs(i_adj[0], i_adj[1], flags))
            # print(count_arr)
            if len(count_arr) < 2:
                ans[i] = 0
            else:
                for ci in range(len(count_arr)):
                    for cj in range(ci + 1, len(count_arr)):
                        ans[i] += count_arr[ci] * count_arr[cj]
        return ans

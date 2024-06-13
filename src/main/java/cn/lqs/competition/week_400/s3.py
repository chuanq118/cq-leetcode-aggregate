import heapq


class Solution:
    def clearStars(self, s: str) -> str:
        flags = [False for _ in range(0, len(s))]
        min_heap = []
        for idx, ch in enumerate(s):
            if ch == '*':
                _, min_idx = heapq.heappop(min_heap)
                flags[-min_idx] = True
                flags[idx] = True
            else:
                heapq.heappush(min_heap, (ord(ch), -idx))

        ans = []
        for i in range(0, len(s)):
            if not flags[i]:
                ans.append(s[i])
        return "".join(ans)

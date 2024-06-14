from typing import List


class Solution:
    def maximumLength(self, s: str) -> int:
        counter: List[List[int]] = [[] for _ in range(26)]
        l = 0
        n = len(s)
        while l < n:
            r = l
            while r < n and s[r] == s[l]:
                r += 1
            cur_len = r - l
            idx = ord(s[l]) - ord('a')
            if len(counter[idx]) < 3:
                counter[idx].append(cur_len)
            else:
                if cur_len > counter[idx][0]:
                    counter[idx][0] = cur_len
            counter[idx].sort()
            l = r
        ans = -1
        for count in counter:
            if len(count) == 0:
                continue
            if len(count) == 2:
                if count[1] > count[0]:
                    ans = max(count[0], ans)
                if count[1] == count[0] and count[0] > 2:
                    ans = max(ans, count[0] - 1)
            if len(count) >= 3:
                ans = max(count[0], ans)
                if count[2] > count[1]:
                    ans = max(count[1], ans)
                if count[2] == count[1] and count[1] > 2:
                    ans = max(ans, count[1] - 1)
            if count[-1] > 2:
                ans = max(count[-1] - 2, ans)
        return ans

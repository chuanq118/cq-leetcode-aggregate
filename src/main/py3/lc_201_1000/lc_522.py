from typing import List


class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def check(prev_strs_params: List[str], s: str) -> bool:
            if len(prev_strs_params) == 0:
                return True
            for prev_str in prev_strs_params:
                l1, l2 = 0, 0
                while l1 < len(s) and l2 < len(prev_str):
                    while l2 < len(prev_str) and prev_str[l2] != s[l1]:
                        l2 += 1
                    if l2 < len(prev_str):
                        l1 += 1
                        l2 += 1
                if l1 == len(s):
                    return False
            return True

        strs.sort(key=lambda s: (-len(s), s))
        idx, n = 0, len(strs)
        prev_strs = []
        while idx < n:
            ni = idx + 1
            while ni < n and strs[ni] == strs[idx]:
                ni += 1
            if ni == (idx + 1) and check(prev_strs, strs[idx]):
                return len(strs[idx])
            else:
                prev_strs.append(strs[idx])
                idx = ni

        return -1


Solution().findLUSlength(["aabbcc", "aabbcc", "cb"])

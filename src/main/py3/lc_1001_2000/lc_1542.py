from functools import cache


class Solution:
    def longestAwesome(self, s: str) -> int:
        char_map = {}
        for c in s:
            char_map[c] = char_map.get(c, 0) + 1

        old_count = 0
        for key in char_map:
            if char_map[key] % 2 != 0:
                old_count += 1

        @cache
        def dfs(l: int, r: int, old_c) -> int:
            if old_c <= 1:
                return r - l + 1
            char_map[s[r]] -= 1
            v1 = dfs(l, r - 1, old_c - 1 if char_map[s[r]] % 2 == 0 else old_c + 1)
            char_map[s[r]] += 1
            char_map[s[l]] -= 1
            v2 = dfs(l + 1, r, old_c - 1 if char_map[s[l]] % 2 == 0 else old_c + 1)
            char_map[s[l]] += 1
            return max(v1, v2)

        return dfs(0, len(s) - 1, old_count)


Solution().longestAwesome("12312312scdscsdcsd")

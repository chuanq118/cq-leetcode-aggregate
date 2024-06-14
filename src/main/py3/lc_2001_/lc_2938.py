class Solution:
    def minimumSteps(self, s: str) -> int:
        r = len(s) - 1
        l = r
        ans = 0
        while l >= 0 and r >= 0:
            while r >= 0 and s[r] == '1':
                r -= 1
            if r >= 0:
                l = min(l, r - 1)
                while l >= 0 and s[l] == '0':
                    l -= 1
                if l >= 0:
                    ans += (r - l)
                    r -= 1
        return ans

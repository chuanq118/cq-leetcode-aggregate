class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stk = []
        n, ans_len = len(num), len(num) - k
        if ans_len == 0:
            return "0"
        for idx, ch in enumerate(num):
            if not stk:
                stk.append(ch)
                continue
            while stk and stk[-1] > ch and (len(stk) + n - idx) > ans_len:
                stk.pop()
            if len(stk) < ans_len:
                stk.append(ch)
        ans = "".join(stk).lstrip('0')
        return "0" if ans == "" else ans

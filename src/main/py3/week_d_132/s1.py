class Solution:
    def clearDigits(self, s: str) -> str:
        new_s = []
        for ch in s:
            if '0' <= ch <= '9':
                if new_s:
                    new_s.pop()
            else:
                new_s.append(ch)
        return "".join(new_s)

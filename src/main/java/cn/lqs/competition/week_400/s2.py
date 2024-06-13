from typing import List


class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: (x[0], x[1]))

        ans = meetings[0][0] - 1

        for i in range(1, len(meetings)):
            if meetings[i][0] <= meetings[i - 1][1]:
                meetings[i][1] = max(meetings[i][1], meetings[i - 1][1])
            else:
                ans += (meetings[i][0] - meetings[i - 1][1] - 1)

        ans += (days - meetings[len(meetings) - 1][1])
        return ans

from typing import List


class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        # 只赢
        ans0 = set()
        # 只输一次
        ans1 = set()
        # 输过超过一次
        ans2 = set()

        for match in matches:
            if match[0] not in ans1 and match[0] not in ans2 and match[0] not in ans0:
                ans0.add(match[0])
            if match[1] in ans0:
                ans0.remove(match[1])
                ans1.add(match[1])
            elif match[1] in ans1:
                ans1.remove(match[1])
                ans2.add(match[1])
            elif match[1] not in ans2:
                ans1.add(match[1])

        list0 = list(ans0)
        list0.sort()
        list1 = list(ans1)
        list1.sort()
        return [list0, list1]

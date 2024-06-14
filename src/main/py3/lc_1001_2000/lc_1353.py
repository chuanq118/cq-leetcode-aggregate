import heapq
from typing import List


# class Solution:
#     def maxEvents(self, events: List[List[int]]) -> int:
#         # events.sort(key=lambda sl: (sl[0], sl[1]))
#         events.sort(key=lambda sl: sl[0])
#         ans = 0
#         day = events[0][0]
#         priority_queue = []
#         heapq.heappush(priority_queue, events[0][1])
#         ei = 1
#         while len(priority_queue) > 0:
#             while ei < len(events) and events[ei][0] <= day:
#                 heapq.heappush(priority_queue, events[ei][1])
#                 ei += 1
#             if heapq.heappop(priority_queue) >= day:
#                 ans += 1
#                 day += 1
#         # for i in range(1, len(events)):
#         #     if events[i][0] <= yesterday:
#         #         if events[i][1] >= (yesterday + 1):
#         #             yesterday += 1
#         #             ans += 1
#         #     else:
#         #         yesterday = events[i][0]
#         #         ans += 1
#         return ans


class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda sl: sl[0])
        ans = 0
        day = events[0][0]
        priority_queue = []
        heapq.heappush(priority_queue, events[0][1])
        ei = 1
        while ei < len(events) or len(priority_queue) > 0:
            while ei < len(events) and events[ei][0] <= day:
                heapq.heappush(priority_queue, events[ei][1])
                ei += 1
            while len(priority_queue) > 0:
                ed = heapq.heappop(priority_queue)
                if ed >= day:
                    ans += 1
                    break
            day += 1
        return ans

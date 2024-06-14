import heapq
from typing import List


class Solution:
    def findMaximumElegance(self, items: List[List[int]], k: int) -> int:
        item_count: int = 0
        kind_items: dict[int, List[int]] = {}
        items.sort(key=lambda it: it[0], reverse=True)
        ans = 0
        final_ans = 0
        pre_nn = 0
        item_pq = []
        for item in items:
            if item_count < k:
                if item[1] not in kind_items:
                    kind_items[item[1]] = [item[0]]
                else:
                    kind_items[item[1]].append(item[0])
                ans += item[0]
                item_count += 1
                if item_count == k:
                    pre_nn = len(kind_items) * len(kind_items)
                    ans += pre_nn
                    final_ans = ans
                    for kind, item_list in kind_items.items():
                        if len(item_list) > 1:
                            heapq.heappush(item_pq, (item_list[-1], kind))
            elif item[1] not in kind_items and len(item_pq) > 0:
                cur_nn = (len(kind_items) + 1) * (len(kind_items) + 1)
                new_ans = ans - item_pq[0][0] + item[0] - pre_nn + cur_nn
                final_ans = max(final_ans, new_ans)
                ans = new_ans
                pre_nn = cur_nn
                top_item = heapq.heappop(item_pq)
                kind_items[top_item[1]].pop()
                kind_items[item[1]] = [item[0]]
                if len(kind_items[top_item[1]]) > 1:
                    heapq.heappush(item_pq, (kind_items[top_item[1]][-1], top_item[1]))
        return final_ans


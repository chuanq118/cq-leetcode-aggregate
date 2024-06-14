from typing import List


class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        ans = [0] * num_people
        idx = 0
        k = 1
        while candies > 0:
            ans[idx] += min(k, candies)
            candies -= k
            k += 1
            idx = (idx + 1) % num_people
        return ans

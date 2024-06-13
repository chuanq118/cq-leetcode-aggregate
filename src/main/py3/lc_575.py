from typing import List


class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        candy_types = set()
        for ct in candyType:
            candy_types.add(ct)
        return min(len(candy_types), int(len(candyType) / 2))

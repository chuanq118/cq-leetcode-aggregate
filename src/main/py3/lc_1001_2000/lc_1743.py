from typing import List


class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        ans = []
        num_dict: dict[int, List[int]] = {}
        for pair in adjacentPairs:
            if pair[0] not in num_dict:
                num_dict[pair[0]] = []
            if pair[1] not in num_dict:
                num_dict[pair[1]] = []
            num_dict[pair[0]].append(pair[1])
            num_dict[pair[1]].append(pair[0])
        prev_key = None
        for key in num_dict:
            if len(num_dict[key]) == 1:
                prev_key = key
                break
        ans.append(prev_key)
        n = len(adjacentPairs) + 1
        pre = None
        while len(ans) < n:
            for val in num_dict[prev_key]:
                if val != pre:
                    pre = prev_key
                    ans.append(val)
                    prev_key = val
                    break
        return ans

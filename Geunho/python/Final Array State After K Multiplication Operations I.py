# https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
import heapq
from typing import List

class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        nums_with_indices = [(num, index) for index, num in enumerate(nums)]
        heapq.heapify(nums_with_indices)

        for _ in range(k):
            num, index = heapq.heappop(nums_with_indices)
            heapq.heappush(nums_with_indices, (num * multiplier, index))

        nums_with_indices.sort(key=lambda e: e[1])
        return [num for num, _ in nums_with_indices]


s = Solution()
assert s.getFinalState([2, 1, 3, 5, 6], 5, 2) == [8, 4, 6, 5, 6]
assert s.getFinalState([1, 2], 3, 4) == [16, 8]
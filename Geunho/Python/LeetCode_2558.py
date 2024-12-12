# https://leetcode.com/problems/take-gifts-from-the-richest-pile/
import heapq
import math
from typing import List


class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        gifts = [-x for x in gifts]
        heapq.heapify(gifts)

        for _ in range(k):
            max_gift = -heapq.heappop(gifts)
            heapq.heappush(gifts, -math.floor(max_gift**0.5))

        return sum([-x for x in gifts])


s = Solution()
assert s.pickGifts([25, 64, 9, 4, 100], 4) == 29
assert s.pickGifts([1, 1, 1, 1], 4) == 4

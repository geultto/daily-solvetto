from bisect import bisect_left, bisect_right
from typing import List


class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        neg = bisect_left(nums, 0)
        pos = len(nums) - bisect_right(nums, 0)
        return max(neg, pos)


s = Solution()
assert s.maximumCount([-2, -1, -1, 1, 2, 3]) == 3
assert s.maximumCount([-3, -2, -1, 0, 0, 0, 1, 2]) == 3
assert s.maximumCount([5, 20, 66, 1314]) == 4
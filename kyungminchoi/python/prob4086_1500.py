from bisect import bisect_left, bisect_right

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        f = bisect_left(nums, 0)
        g = bisect_right(nums, 0)
        n = len(nums)

        return max(f, n - g)
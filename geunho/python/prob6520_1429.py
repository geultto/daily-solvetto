import collections
from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        queue = collections.deque(nums)
        sorted_queue = sorted(queue)
        for _ in range(len(nums)):
            queue.rotate(1)
            if list(queue) == sorted_queue:
                return True

        return False


s = Solution()
assert s.check([3, 4, 5, 1, 2])
assert not s.check([2, 1, 3, 4])
assert s.check([1, 2, 3])
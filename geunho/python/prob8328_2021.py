import collections
from typing import List


class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        return (
            True
            if all(x % 2 == 0 for x in collections.Counter(nums).values())
            else False
        )


s = Solution()
assert s.divideArray([3, 2, 3, 2, 2, 2])
assert not s.divideArray([1, 2, 3, 4])
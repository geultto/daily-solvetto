import heapq
from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        answer = 0
        heapq.heapify(nums)
        while len(nums) >= 2 and (smallest_num := heapq.heappop(nums)) < k:
            next_smallest_num = heapq.heappop(nums)
            heapq.heappush(nums, 2 * smallest_num + next_smallest_num)
            answer += 1

        return answer


s = Solution()
assert s.minOperations([2, 11, 10, 1, 3], 10) == 2
assert s.minOperations([1, 1, 2, 4, 9], 20) == 4
assert s.minOperations([1, 2], 3) == 1
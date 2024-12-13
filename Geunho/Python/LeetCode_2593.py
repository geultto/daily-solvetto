import heapq
from typing import List


class Solution:
    def findScore(self, nums: List[int]) -> int:
        num_of_elements = len(nums)
        num_with_index = [(num, index) for index, num in enumerate(nums)]
        heapq.heapify(num_with_index)

        score = 0
        marked_entries = set()
        while num_with_index:
            entry = heapq.heappop(num_with_index)
            if entry in marked_entries:
                continue

            num, index = entry
            score += num

            marked_entries.add(entry)
            if index > 0:
                marked_entries.add((nums[index - 1], index - 1))

            if index < num_of_elements - 1:
                marked_entries.add((nums[index + 1], index + 1))

        return score


s = Solution()
assert s.findScore([2, 1, 3, 4, 5, 2]) == 7
assert s.findScore([2, 3, 5, 1, 3, 2]) == 5
assert s.findScore([1]) == 1

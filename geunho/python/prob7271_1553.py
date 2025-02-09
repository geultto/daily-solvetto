from collections import defaultdict
from typing import List


class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        total_nums = len(nums)
        total_num_of_pairs = ((total_nums - 1) * total_nums) // 2
        diff_dict = defaultdict(list)
        for index, num in enumerate(nums):
            diff_dict[index - num].append(index)

        answer = 0
        for key, val in diff_dict.items():
            temp = len(val)
            answer += ((temp - 1) * temp) // 2
        return total_num_of_pairs - answer


s = Solution()
assert s.countBadPairs([4, 1, 3, 3]) == 5
assert s.countBadPairs([1, 2, 3, 4, 5]) == 0
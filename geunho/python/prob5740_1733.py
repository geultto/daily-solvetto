from typing import List


class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        num_of_elements = len(nums)
        for i in range(num_of_elements - 1):
            if nums[i] == nums[i + 1]:
                nums[i] *= 2
                nums[i + 1] = 0

        answers = [x for x in nums if x != 0]
        return answers + [0] * (num_of_elements - len(answers))


s = Solution()
assert s.applyOperations([1, 2, 2, 1, 1, 0]) == [1, 4, 2, 0, 0, 0]
assert s.applyOperations([0, 1]) == [1, 0]
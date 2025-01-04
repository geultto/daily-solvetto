from typing import List


class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        prefix_sum = [nums[0]]
        for i in range(1, len(nums)):
            prefix_sum.append(prefix_sum[i - 1] + nums[i])
        total_sum = prefix_sum[-1]

        answer = 0
        for i in range(len(nums) - 1):
            if 2 * prefix_sum[i] >= total_sum:
                answer += 1

        return answer


s = Solution()
assert s.waysToSplitArray([10, 4, -8, 7]) == 2
assert s.waysToSplitArray([2, 3, 1, 0]) == 2
class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        answer = nums[0]
        
        previous = nums[0]
        array_sum = nums[0]
        for num in nums[1:]:
            if num > previous:
                array_sum += num
            else:
                answer = max(answer, array_sum)
                array_sum = num
            previous = num
        
        return max(answer, array_sum)
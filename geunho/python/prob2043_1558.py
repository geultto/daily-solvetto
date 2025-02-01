class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        for index in range(len(nums) - 1):
            if (nums[index] + nums[index + 1]) % 2 == 0:
                return False
        return True
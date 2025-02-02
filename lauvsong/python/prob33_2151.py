class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            mid = (l + r) >> 1

            if nums[mid] == target:
                return mid
            
            if nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid-1
                else:
                    l = mid + 1
            
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            
        return -1



"""
target 의 인덱스를 구해라.
O(logn) 만에 찾아야함!

nums 는 회전된  nums임
이진 탐색

"""
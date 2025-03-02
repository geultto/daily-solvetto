from typing import List


class Solution:
    def mergeArrays(
        self, nums1: List[List[int]], nums2: List[List[int]]
    ) -> List[List[int]]:
        ptr1 = 0
        ptr2 = 0

        answer = []
        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1][0] < nums2[ptr2][0]:
                answer.append([nums1[ptr1][0], nums1[ptr1][1]])
                ptr1 += 1
            elif nums1[ptr1][0] > nums2[ptr2][0]:
                answer.append([nums2[ptr2][0], nums2[ptr2][1]])
                ptr2 += 1
            else:
                answer.append([nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1]])
                ptr1 += 1
                ptr2 += 1

        if ptr1 < len(nums1):
            answer.extend(nums1[ptr1:])

        if ptr2 < len(nums2):
            answer.extend(nums2[ptr2:])

        return answer


s = Solution()
assert s.mergeArrays([[1, 2], [2, 3], [4, 5]], [[1, 4], [3, 2], [4, 1]]) == [
    [1, 6],
    [2, 3],
    [3, 2],
    [4, 6],
]
assert s.mergeArrays([[2, 4], [3, 6], [5, 5]], [[1, 3], [4, 3]]) == [
    [1, 3],
    [2, 4],
    [3, 6],
    [4, 3],
    [5, 5],
]
from typing import List


class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n_square = len(grid) ** 2
        expected_sum = int(n_square * (n_square + 1) * 0.5)

        num_set = set()
        total_sum = 0
        for row in grid:
            for num in row:
                num_set.add(num)
            total_sum += sum(row)
        sum_of_unique_num = sum(num_set)
        return [total_sum - sum_of_unique_num, expected_sum - sum_of_unique_num]


s = Solution()
assert s.findMissingAndRepeatedValues([[1, 3], [2, 2]]) == [2, 4]
assert s.findMissingAndRepeatedValues([[9, 1, 7], [8, 9, 2], [3, 4, 6]]) == [9, 5]
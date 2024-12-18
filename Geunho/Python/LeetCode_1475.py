# https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
from typing import List


class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []
        for index, price in enumerate(prices):
            while stack and prices[stack[-1]] >= price:
                prices[stack.pop()] -= price
            stack.append(index)
        return prices


s = Solution()
assert s.finalPrices([8, 4, 6, 2, 3]) == [4, 2, 4, 2, 3]
assert s.finalPrices([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]
assert s.finalPrices([10, 1, 1, 6]) == [9, 0, 1, 6]

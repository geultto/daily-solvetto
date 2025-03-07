from typing import List


class Solution:
    def get_primes(self, left: int, right: int) -> List[int]:
        result = [True] * (right + 1)

        for i in range(2, int(right**0.5) + 1):
            if not result[i]:
                continue

            for j in range(i * i, right + 1, i):
                result[j] = False

        return [num for num, is_prime in enumerate(result) if is_prime and num >= max(2, left)]

    def closestPrimes(self, left: int, right: int) -> List[int]:
        primes = self.get_primes(left, right)

        if len(primes) < 2:
            return [-1, -1]

        result = [primes[0], primes[1]]
        for i in range(1, len(primes) - 1):
            if primes[i + 1] - primes[i] < result[1] - result[0]:
                result = [primes[i], primes[i + 1]]

        return result


s = Solution()
assert s.closestPrimes(10, 19) == [11, 13]
assert s.closestPrimes(4, 6) == [-1, -1]
assert s.closestPrimes(1, 1000000) == [2, 3]
from itertools import permutations as permu

class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        result = 0

        for i in range(1, len(tiles)+1):
            permu_data = set(list(permu(list(tiles), i)))
            result += len(permu_data)

        return result
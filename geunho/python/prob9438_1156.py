from itertools import permutations


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        answer = 0
        for r in range(1, len(tiles) + 1):
            answer += len(set(permutations(tiles, r)))
        return answer
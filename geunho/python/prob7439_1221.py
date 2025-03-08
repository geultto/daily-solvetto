class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        num_chars = len(blocks)
        answer = num_chars
        for index in range(num_chars - k + 1):
            num_blacks = sum(1 for c in blocks[index : index + k] if c == 'B')
            answer = min(answer, k - num_blacks)

        return answer


s = Solution()
assert s.minimumRecolors('BWWWBB', 6) == 3
assert s.minimumRecolors('WBBWWBBWBW', 7) == 3
assert s.minimumRecolors('WBWBBBW', 2) == 0
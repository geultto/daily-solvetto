class Solution:
    def maxScore(self, s: str) -> int:
        num_of_zeros = 1 if s[0] == '0' else 0
        num_of_ones = sum(int(x) for x in s[1:])
        answer = num_of_zeros + num_of_ones

        for i in range(1, len(s) - 1):
            num_of_zeros += 1 if s[i] == '0' else 0
            num_of_ones -= 1 if s[i] == '1' else 0
            answer = max(answer, num_of_zeros + num_of_ones)

        return answer


s = Solution()
assert s.maxScore('011101') == 5
assert s.maxScore('00111') == 5
assert s.maxScore('1111') == 3
assert s.maxScore('00') == 1
assert s.maxScore('01') == 2
assert s.maxScore('11') == 1

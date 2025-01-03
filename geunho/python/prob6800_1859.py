from typing import List


class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        def _is_vowel_string(w: str) -> int:
            return 1 if w[0] in 'aeiou' and w[-1] in 'aeiou' else 0

        count_arr = [_is_vowel_string(words[0])]
        for index in range(1, len(words)):
            count_arr.append(count_arr[index - 1] + _is_vowel_string(words[index]))

        answer = []
        for start_idx, end_idx in queries:
            count_by_end_idx = count_arr[end_idx]
            count_by_start_idx = 0 if start_idx == 0 else count_arr[start_idx - 1]
            answer.append(count_by_end_idx - count_by_start_idx)
        return answer


s = Solution()
assert s.vowelStrings(
    words=['aba', 'bcb', 'ece', 'aa', 'e'], queries=[[0, 2], [1, 4], [1, 1]]
) == [2, 3, 0]
assert s.vowelStrings(words=['a', 'e', 'i'], queries=[[0, 2], [0, 1], [2, 2]]) == [
    3,
    2,
    1,
]
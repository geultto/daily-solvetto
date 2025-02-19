from typing import List


class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        answer = set()

        def generate(chars: List[str]):
            if len(chars) == n:
                answer.add(''.join(chars))
                return

            for index, char in enumerate(['a', 'b', 'c']):
                if not chars or (chars and chars[-1] != char):
                    chars.append(char)
                    generate(chars)
                    chars.pop()

        generate([])
        sorted_answers = sorted(answer)
        return sorted_answers[k - 1] if len(sorted_answers) >= k else ''


s = Solution()
assert s.getHappyString(1, 3) == 'c'
assert s.getHappyString(1, 4) == ''
assert s.getHappyString(3, 9) == 'cab'
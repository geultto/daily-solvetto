from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums[0])
        num_set = set(nums)
        answer = []

        def generate(chars: List[str]):
            if len(chars) == n:
                binary = ''.join(chars)
                if binary not in num_set:
                    answer.append(binary)
                return

            for char in ('0', '1'):
                chars.append(char)
                generate(chars)
                chars.pop()

        generate([])
        return answer[0]


s = Solution()
assert s.findDifferentBinaryString(['01', '10']) in {'00', '11'}
assert s.findDifferentBinaryString(['00', '01']) in {'10', '11'}
assert s.findDifferentBinaryString(['111', '011', '001']) in {
    '000',
    '101',
    '010',
    '100',
    '100',
}
# class Solution:
#     def getHappyString(self, n: int, k: int) -> str:
#         answer = set()
#
#         def generate(chars: List[str]):
#             if len(chars) == n:
#                 answer.add(''.join(chars))
#                 return
#
#             for index, char in enumerate(['a', 'b', 'c']):
#                 if not chars or (chars and chars[-1] != char):
#                     chars.append(char)
#                     generate(chars)
#                     chars.pop()
#
#         generate([])
#         sorted_answers = sorted(answer)
#         return sorted_answers[k - 1] if len(sorted_answers) >= k else ''
#
#
# s = Solution()
# assert s.getHappyString(1, 3) == 'c'
# assert s.getHappyString(1, 4) == ''
# assert s.getHappyString(3, 9) == 'cab'
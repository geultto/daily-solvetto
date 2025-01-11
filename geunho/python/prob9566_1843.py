from typing import List


class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        num_of_words = len(words)

        answer = 0
        for i in range(num_of_words - 1):
            for j in range(i + 1, num_of_words):
                str1 = words[i]
                str2 = words[j]

                if len(str1) > len(str2):
                    continue

                if str1 == str2[: len(str1)] and str1 == str2[-len(str1) :]:
                    answer += 1

        return answer


s = Solution()
assert s.countPrefixSuffixPairs(['a', 'aba', 'ababa', 'aa']) == 4
assert s.countPrefixSuffixPairs(['pa', 'papa', 'ma', 'mama']) == 2
assert s.countPrefixSuffixPairs(['abab', 'ab']) == 0
# https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence


class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        for index, word in enumerate(sentence.split()):
            if word[: len(searchWord)] == searchWord:
                return index + 1

        return -1


s = Solution()
assert s.isPrefixOfWord('i love eating burger', 'burg') == 4
assert s.isPrefixOfWord('this problem is an easy problem', 'pro') == 2
assert s.isPrefixOfWord('i am tired', 'you') == -1

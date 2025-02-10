class Solution:
    def clearDigits(self, s: str) -> str:
        stack = []
        for char in s:
            if char.isdigit():
                stack.pop()
            else:
                stack.append(char)

        return ''.join(stack)


solution = Solution()
assert solution.clearDigits('abc') == 'abc'
assert solution.clearDigits('cb34') == ''
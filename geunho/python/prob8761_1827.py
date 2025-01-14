class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2 == 1:
            return False

        stack = []
        indices = []
        for index, (char, flag) in enumerate(zip(s, locked)):
            if flag == '0':
                indices.append(index)
            elif char == '(':
                stack.append(index)
            elif char == ')':
                if stack:
                    stack.pop()
                elif indices:
                    indices.pop()
                else:
                    return False

        while stack and indices and stack[-1] < indices[-1]:
            stack.pop()
            indices.pop()

        return False if stack else True


solution = Solution()
assert solution.canBeValid('()', '11')
assert solution.canBeValid(')(', '00')
assert solution.canBeValid(s='))()))', locked='010100')
assert solution.canBeValid(s='()()', locked='0000')
assert not solution.canBeValid(s=')', locked='0')
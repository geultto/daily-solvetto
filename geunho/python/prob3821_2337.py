class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        stack = []

        if len(part) == 1:
            return ''.join(x for x in s if x != part)

        for char in s:
            if (
                len(stack) >= len(part) - 1
                and f'{"".join(stack[-len(part) + 1:])}{char}' == part
            ):
                for _ in range(len(part) - 1):
                    stack.pop()
            else:
                stack.append(char)

        return ''.join(stack)
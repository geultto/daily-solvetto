import sys

n = int(sys.stdin.readline())
answer = []
for i in range(n, 0, -1):
    stars = '*' * i
    space = ' ' * (2 * (n - i))
    answer.append(f'{stars}{space}{stars}')

print('\n'.join(answer))
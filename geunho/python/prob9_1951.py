import sys

n = int(sys.stdin.readline())
sequence = []
current = 9
for _ in range(n * n):
    if current == 0:
        current = 9
    sequence.append(str(current))
    current -= 1

answer = []
for i in range(0, n * n, n):
    answer.append(''.join(x for x in sequence[i : i + n]))

print('\n'.join(answer))
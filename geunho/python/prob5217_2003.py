import collections
import sys

n, t = [int(x) for x in sys.stdin.readline().split()]
row1 = [int(x) for x in sys.stdin.readline().split()]
row2 = [int(x) for x in sys.stdin.readline().split()]

queue = collections.deque(row1 + row2[::])
queue.rotate(t)

answer = []
row = []
for _ in range(n):
    row.append(str(queue.popleft()))

answer.append(' '.join(row))
row = []
for _ in range(n):
    row.append(str(queue.popleft()))
answer.append(' '.join(row))
print('\n'.join(answer))
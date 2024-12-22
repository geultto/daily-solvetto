# https://www.acmicpc.net/problem/11003
import sys
from collections import deque

N, L = [int(x) for x in sys.stdin.readline().split()]
sequence = (int(x) for x in sys.stdin.readline().split())
queue = deque()
answer = []
for index, val in enumerate(sequence):
    while queue and queue[-1][1] > val:
        queue.pop()

    queue.append((index, val))
    while queue and queue[0][0] < index - L + 1:
        queue.popleft()

    answer.append(queue[0][1])

print(' '.join([str(x) for x in answer]))

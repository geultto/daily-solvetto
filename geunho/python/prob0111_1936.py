import sys
from collections import deque

num_of_elements = int(sys.stdin.readline())
sequence = deque(range(1, num_of_elements + 1))

while len(sequence) > 1:
    sequence.popleft()
    sequence.rotate(-1)

print(sequence[0])
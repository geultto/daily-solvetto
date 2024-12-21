# https://www.acmicpc.net/problem/5430
import sys
from collections import deque

num_of_test_cases = int(sys.stdin.readline())
answer = ['' for _ in range(num_of_test_cases)]
for i in range(num_of_test_cases):
    function = deque(sys.stdin.readline().rstrip())
    _ = sys.stdin.readline()
    queue = deque((x for x in sys.stdin.readline().rstrip()[1:-1].split(',') if x))

    num_of_reverse = 0
    while function:
        command = function.popleft()

        if command == 'D':
            if not queue:
                answer[i] = 'error'
                break

            if num_of_reverse % 2 == 0:
                queue.popleft()
            else:
                queue.pop()
        else:  # command == 'R'
            num_of_reverse += 1

    if num_of_reverse % 2 == 1:
        queue.reverse()

    if not answer[i]:
        answer[i] = '[' + ','.join(queue) + ']'

print('\n'.join(answer))

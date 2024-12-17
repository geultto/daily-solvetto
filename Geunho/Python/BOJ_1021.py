import collections
import sys

num_of_elements, _ = [int(x) for x in sys.stdin.readline().split()]
locations = [int(x) for x in sys.stdin.readline().split()]
queue = collections.deque(range(1, num_of_elements + 1))

answer = 0
for location in locations:
    index = queue.index(location)

    queue_length = len(queue)
    if index <= queue_length // 2:
        queue.rotate(-1 * index)
        answer += index
    else:
        queue.rotate(queue_length - index)
        answer += queue_length - index
    queue.popleft()

print(answer)

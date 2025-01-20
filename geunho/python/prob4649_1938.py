import heapq
import sys

num_of_elements = int(sys.stdin.readline())
arr = [int(x) for x in sys.stdin.readline().split()]

arr_with_index = [(-x, index + 1) for index, x in enumerate(arr)]
heapq.heapify(arr_with_index)

answer = []
while True:
    _, pos = heapq.heappop(arr_with_index)

    answer.append(str(pos))
    if pos == 1:
        break

    arr_with_index = [(-x, index + 1) for index, x in enumerate(arr[: pos - 1])]
    heapq.heapify(arr_with_index)

print(' '.join(answer))
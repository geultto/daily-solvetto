import heapq
import sys

num_of_elements = int(sys.stdin.readline())
elements = [int(x) for x in sys.stdin.readline().split()]

heap = []
for element in elements:
    heapq.heappush(heap, element)

answer = []
while heap:
    answer.append(heapq.heappop(heap))
print(' '.join([str(x) for x in answer]))
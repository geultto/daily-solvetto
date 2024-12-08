# https://leetcode.com/problems/two-best-non-overlapping-events/
import heapq
from dataclasses import dataclass
from typing import List


@dataclass
class _Event:
    start_time: int
    end_time: int
    value: int


class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events = [_Event(e[0], e[1], e[2]) for e in events]
        events = sorted(events, key=lambda e: e.start_time)

        pq = []
        max_value = 0
        answer = 0
        for event in events:
            while pq and pq[0][0] < event.start_time:
                max_value = max(max_value, pq[0][1])
                heapq.heappop(pq)

            answer = max(answer, max_value + event.value)
            heapq.heappush(pq, (event.end_time, event.value))

        return answer


s = Solution()
assert s.maxTwoEvents([[1, 5, 3], [1, 5, 1], [6, 6, 5]]) == 8
assert s.maxTwoEvents([[1, 3, 2], [4, 5, 2], [2, 4, 3]]) == 4
assert s.maxTwoEvents([[1, 3, 2], [4, 5, 2], [1, 5, 5]]) == 5

# https://www.acmicpc.net/problem/1158
import sys
from abc import ABC
from dataclasses import dataclass
from typing import Optional


class BaseNode(ABC):
    pass


@dataclass
class Node(BaseNode):
    val: int
    next: Optional[BaseNode] = None


num_of_people, k = [int(x) for x in sys.stdin.readline().split()]
head = Node(1)
current = head
for i in range(1, num_of_people):
    current.next = Node(i + 1)
    current = current.next
current.next = head

answer = []
current = head
prev = head
while len(answer) < num_of_people:
    for _ in range(k - 1):
        prev = current
        current = current.next

    answer.append(current.val)
    current = current.next
    prev.next = current

answer = ', '.join([str(x) for x in answer])
print(f'<{answer}>')

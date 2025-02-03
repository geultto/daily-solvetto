import collections
import sys

string = collections.deque(sys.stdin.readline().rstrip())
commands = sys.stdin.readline().rstrip()

for command in commands:
    if command == 'L':
        string.rotate(-1)
    else:
        string.rotate(1)

print(''.join(string))
import sys

a, b, c, d = [int(x) for x in sys.stdin.readline().split()]
print((c * 60 + d) - (a * 60 + b))
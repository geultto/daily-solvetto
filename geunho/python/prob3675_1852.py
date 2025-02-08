import sys

n, m = [int(x) for x in sys.stdin.readline().split()]
grid = [[0 for _ in range(n)] for _ in range(n)]

num = 1
for _ in range(m):
    row, col = [int(x) for x in sys.stdin.readline().split()]
    grid[row - 1][col - 1] = num
    num += 1

for row in range(n):
    print(' '.join(str(x) for x in grid[row]))
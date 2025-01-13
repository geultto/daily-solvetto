import sys

n = int(sys.stdin.readline())
grid = []
for _ in range(n):
    row = [int(x) for x in sys.stdin.readline().split()]
    grid.append(row)

answer = 0
for row in range(n - 2):
    for col in range(n - 2):
        current_sum = (
            sum(grid[row][col : col + 3])
            + sum(grid[row + 1][col : col + 3])
            + sum(grid[row + 2][col : col + 3])
        )
        answer = max(answer, current_sum)

print(answer)
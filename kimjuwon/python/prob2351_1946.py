import sys


def in_range(x, y, n):
    return True if 0 <= x < n and 0 <= y < n else False


n = int(sys.stdin.readline())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
max_route = -1

# 1 : / , 2 : \
one = {"L": "D", "R": "U", "U": "R", "D": "L"}

two = {"L": "U", "R": "D", "U": "L", "D": "R"}

d_dict = {"L": [0, -1], "R": [0, 1], "U": [-1, 0], "D": [1, 0]}

starts = []

for i in range(n):
    starts.append([0, i, "D"])
    starts.append([i, 0, "R"])
    starts.append([n - 1, i, "U"])
    starts.append([i, n - 1, "L"])

for s in starts:
    r, c, d = s
    route = 1

    while in_range(r, c, n):
        if in_range(r, c, n):
            if grid[r][c] == 1:
                d = one[d]
            elif grid[r][c] == 2:
                d = two[d]
        x, y = d_dict[d]
        r += x
        c += y
        route += 1

    max_route = max(route, max_route)

print(max_route)
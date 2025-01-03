import sys

n = int(sys.stdin.readline())
r, c = tuple(map(int, sys.stdin.readline().split()))
arr = [list(sys.stdin.readline().rstrip()) for _ in range(n)]

r -= 1
c -= 1

can_route = 0
count_route = 0


def can_go(x, y, arr):
    return True if arr[x][y] == "." else False


def in_range(x, y, n):
    return True if 0 <= x < n and 0 <= y < n else False


for i in range(n):
    for j in range(n):
        if arr[i][j] == ".":
            can_route += 1

# 우, 상, 좌, 하
dx, dy = [0, -1, 0, 1], [1, 0, -1, 0]
d = 0

while count_route <= can_route:
    check = 0
    for x, y in zip(dx, dy):
        if in_range(r + x, c + y, n) and arr[r + x][c + y] == "#":
            check += 1
    if check == 4:
        count_route = can_route + 1
        break
    x, y = dx[d], dy[d]
    w = d - 1
    if in_range(r + dx[w], c + dy[w], n) and arr[r + dx[w]][c + dy[w]] == "#":
        if in_range(r + x, c + y, n) is False:
            count_route += 1
            break
        else:
            if arr[r + x][c + y] == "#":
                d = 0 if d == 3 else d + 1
            else:
                r += x
                c += y
                count_route += 1
    else:
        d = 3 if d == 0 else d - 1
        x, y = dx[d], dy[d]
        if in_range(r + x, c + y, n) is False:
            count_route += 1
            break
        else:
            if arr[r + x][c + y] == "#":
                d = 0 if d == 3 else d + 1
            else:
                r += x
                c += y
                count_route += 1


print(count_route if count_route <= can_route else -1)
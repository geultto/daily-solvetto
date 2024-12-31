import sys

n, r, c = tuple(map(int, sys.stdin.readline().split()))
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

def in_range(r, c, n):
    return True if 0 <= r < n and 0 <= c < n else False

r -= 1
c -= 1

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
checker = True
dist = [ arr[r][c] ]
while checker is True: 
    checker = False
    for i in range(4):
        x, y = dx[i], dy[i]
        if in_range(r+x, c+y, n) and arr[r+x][c+y] > arr[r][c] : 
            checker= True
            dist.append(arr[r+x][c+y])
            r = r+x
            c = c+y
            break

for d in dist : 
    print(d, end= " ")
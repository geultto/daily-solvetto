import sys
from collections import deque

def in_range(x, y, n):
    return True if 0 <= x < n and 0 <= y < n else False

APPLE = -1

n, m, k = tuple(map(int, sys.stdin.readline().split()))
arr = [[0 for _ in range(n)] for _ in range(n) ]
arr[0][0] = 1
h = [0,0]
t = [0,0]

for _ in range(m):
    x, y = tuple(map(int, sys.stdin.readline().split()))
    arr[x-1][y-1] = APPLE 

moves = [ sys.stdin.readline().split() for _ in range(k)]
exit = False
total = 0
d_q = deque([])



for move in moves : 
    d, time = move
    time = int(time)

    x, y = 0, 0 
    if d == "U":
        x, y = -1, 0
    elif d == "D" :
        x, y = 1, 0 
    elif d == "R":
        x, y = 0, 1 
    elif d == "L":
        x, y = 0, -1

    for _ in range(time) : 
        h[0] += x
        h[1] += y
        r, c = h[0], h[1]
        arr[t[0]][t[1]] = 0 
        if in_range(r, c, n) and arr[r][c] != 1 :
            d_q.append(d)
            if arr[r][c] != APPLE : 
                t_d = d_q.popleft()
                if t_d == "U":
                    t[0] += -1
                elif t_d == "D" :
                    t[0] += 1 
                elif t_d == "R":
                    t[1] += 1 
                elif t_d == "L":
                    t[1] += -1
            else : 
                arr[t[0]][t[1]] = 1
            total += 1
            arr[r][c] = 1
        else : 
            total += 1
            exit = True
            break

    if exit : 
        break

print(total)
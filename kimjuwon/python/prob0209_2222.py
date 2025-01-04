import sys

n, m, r, c = tuple(map(int, sys.stdin.readline().split()))
directions = sys.stdin.readline().split()
arr = [[ 0 for _ in range(n) ] for _ in range(n) ]

r -= 1
c -= 1

def in_range(x, y, n): 
    return True if 0 <= x < n and 0 <= y < n else False

x, y = 0, 0
T, D, R, L, U, B = 1, 2, 3, 4, 5, 6
arr[r][c] = B

for d in directions : 
    
    if d == "U" : 
        x, y = -1, 0
    elif d == "D":
        x, y = 1, 0
    elif d == "R":
        x, y = 0, 1
    elif d =="L":
        x, y = 0, -1

    if in_range(r+x, c+y, n):
        r += x
        c += y
        if d == "U" : 
            U, D, B, T = T, B, U, D
        elif d == "D":
            U, D, B, T = B, T, D, U
        elif d == "R":
            B, T, L, R = R, L, B, T
        elif d =="L":
            B, T, L, R = L, R, T, B
        
        arr[r][c] = B

sum_grid = 0 
for i in range(n):
    for j in range(n):
        sum_grid += arr[i][j]

print(sum_grid)
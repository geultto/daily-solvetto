import sys 

n, m = tuple(map(int, sys.stdin.readline().split()))
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

def in_range(x,y,n):
    return True if 0 <= x < n and 0 <= y < n else False 

def can_move(r, c, n, arr):
    dx, dy = [-1,-1,-1,0,0,1,1,1],[-1,0,1,-1,1,-1,0,1]
    max_num = -1 
    n_r, n_c = 0, 0
    for x,y in zip(dx,dy):
        if in_range(r+x, c+y, n) and arr[r+x][c+y] > max_num : 
            max_num = arr[r+x][c+y]
            n_r, n_c = r+x, c+y
    return n_r, n_c

for _ in range(m):
    for k in range(1, n*n+1):
        move_out = False
        for i in range(n):
            for j in range(n):
                if arr[i][j] == k:
                    r, c = can_move(i,j,n,arr)
                    arr[i][j], arr[r][c] = arr[r][c], arr[i][j]
                    move_out = True
                    break
            if move_out is True : 
                break

for i in range(n):
    for j in range(n):
        print(arr[i][j], end = " ")
    print()
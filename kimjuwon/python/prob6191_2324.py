import sys 
from collections import deque

n, m = tuple(map(int, sys.stdin.readline().split()))
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
nums = list(map(int, sys.stdin.readline().split()))

for i in range(n):
    for j in range(n):
        grid[i][j] = (grid[i][j], [grid[i][j]])

def in_range(x,y,n):
    return True if 0 <= x < n and 0 <= y < n else False

def can_move(r,c,arr,n):
    dx = [-1,-1,-1, 0,0, 1,1,1]
    dy = [-1, 0, 1,-1,1,-1,0,1]
    max_num = None
    n_r, n_c = r, c
    for x, y in zip(dx,dy):
        if in_range(r+x,c+y,n) :
            if grid[r+x][c+y][1]:
                if max_num is None: 
                    max_num = grid[r+x][c+y][0]
                    n_r, n_c = r+x, c+y
                else : 
                    if max_num < grid[r+x][c+y][0]:
                        n_r, n_c, = r+x, c+y
                        max_num = grid[r+x][c+y][0]

    return n_r, n_c

for num in nums : 
    for i in range(n):
        out = False
        for j in range(n):
            index = -1
            for idx, value in enumerate(grid[i][j][1]):
                if value == num : 
                    index = idx 
            if index != -1:
                r, c = can_move(i,j,grid,n)

                if (r,c) != (i,j):
                    move = grid[i][j][1][:index+1]
                    not_move = grid[i][j][1][index+1:]
                    max_move = -1
                    max_notmove = -1
                    for v in move : 
                        if v > max_move : 
                            max_move = v
                    for v in not_move : 
                        if v > max_notmove : 
                            max_notmove = v
                    
                    grid[r][c] = (max(grid[r][c][0], max_move), move+grid[r][c][1])
                    grid[i][j] = (max_notmove, not_move)
                    out = True
                    break
        if out : 
            break

    
for i in range(n):
    for j in range(n):
        if grid[i][j][1]:
            for ele in grid[i][j][1]:
                print(ele, end=" ")
            print()
        else : 
            print(None)
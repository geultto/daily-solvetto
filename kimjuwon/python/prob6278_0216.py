import sys 

n, m, t = tuple(map(int, sys.stdin.readline().split()))
grid = [[ 0 for _ in range(n) ] for _ in range(n) ] 

direction = {
    "U":[-1, 0],
    "D":[ 1, 0],
    "R":[ 0, 1],
    "L":[ 0,-1]
}

transform = {
    "U":"D",
    "L":"R",
    "D":"U",
    "R":"L"
}

def in_range(x,y,n):
    return True if 0 <= x < n and 0 <= y < n else False 

for i in range(m):
    r, c, d, w = sys.stdin.readline().split()
    grid[int(r)-1][int(c)-1] = (d,int(w),i)


for _ in range(t):
    new_grid = [[0 for _ in range(n)] for _ in range(n)]
    for r in range(n):
        for c in range(n):
            if grid[r][c] : 
                d, w, i = grid[r][c]
                x, y = direction[d]
                if in_range(r+x,c+y,n):
                    if new_grid[r+x][c+y] : 
                        new_grid[r+x][c+y].append((d,w,i))
                    else : 
                        new_grid[r+x][c+y] = [(d,w,i)]
                else : 
                    d = transform[d]
                    if new_grid[r][c] : 
                        new_grid[r][c].append((d, w, i))
                    else : 
                        new_grid[r][c] = [(d, w, i)]

    for r in range(n):
        for c in range(n):
            if new_grid[r][c]  : 
                if len(new_grid) == 1 : 
                    grid[r][c] = new_grid[r][c][0]
                else : 
                    n_d, n_w, n_i = "", 0, -1
                    for i in range(len(new_grid[r][c])):
                        d, w, i = new_grid[r][c][i]
                        if i > n_i : 
                            n_i = i 
                            n_d = d 
                        n_w += w
                    grid[r][c] = (n_d, n_w, n_i)
            else : 
                grid[r][c] = new_grid[r][c]


count = 0 
max_w = 0

for r in range(n):
    for c in range(n):
        if grid[r][c] : 
            _, w, _ = grid[r][c]
            max_w = max(max_w, w)
            count+=1

print(count, max_w)
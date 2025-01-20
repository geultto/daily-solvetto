import sys  

n, m, t, k = tuple(map(int, sys.stdin.readline().split()))
beads = [ sys.stdin.readline().split() for _ in range(m) ]
grid = [[ 0 for _ in range(n)] for _ in range(n)]

for i, bead in enumerate(beads):
    r, c, d, v = bead
    r = int(r)-1
    c = int(c)-1
    grid[r][c] = [(d, int(v), i+1)]


def can_move(r, c, idx, n, grid):
    directions = {
        "U":[-1,0],
        "D":[ 1,0],
        "R":[ 0,1],
        "L":[0,-1]
    }

    transform = {
        "U":"D",
        "D":"U",
        "L":"R",
        "R":"L"
    }

    d, v, _ = grid[r][c][idx]
    x, y = directions[d]
    
    if r+x*v > n-1 : 
        share = (r+x*v) // (n-1)
        mod = (r+x*v) % (n-1)

        if share % 2 : 
            r = (n-1) - (mod)
            d = transform[d]
        else : 
            r = mod
        c = c+y*v
    elif r+x*v < 0 :
        share = abs(r+x*v) // (n-1)
        mod = abs(r+x*v) % (n-1)

        if share % 2 : 
            r = (n-1) - mod
        else :
            r = mod
            d = transform[d]
        c = c+y*v
    else : 
        r += x*v
        if c+y*v > n-1 : 
            share = (c+y*v) // (n-1)
            mod = (c+y*v) % (n-1)

            if share % 2 : 
                c = (n-1) - (mod)
                d = transform[d]
            else : 
                c = mod
        elif c+y*v < 0 : 
            share = abs(c+y*v) // (n-1)
            mod = abs(c+y*v) % (n-1)

            if share % 2 : 
                c = (n-1) - (mod)
            else : 
                c = mod
                d = transform[d]
        else : 
            c += y*v

    return r, c, d

                    

for _ in range(t):
    next_grid = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if grid[i][j] != 0 : 
                for idx in range(len(grid[i][j])):
                    r, c, d = can_move(i,j,idx,n,grid)
                    old_d, v, index = grid[i][j][idx]
                    if next_grid[r][c] == 0 : 
                        next_grid[r][c] = [(d, v, index)]
                    else : 
                        next_grid[r][c].append((d, v, index))

    for i in range(n):
        for j in range(n):
            if next_grid[i][j] != 0 and len(next_grid[i][j]) > k : 
                next_grid[i][j].sort(key = lambda x:(x[1],x[2]), reverse=True)
                out = len(next_grid[i][j]) - k
                for _ in range(out):
                    next_grid[i][j].pop()
                if next_grid[i][j]: 
                    grid[i][j] = next_grid[i][j]
                else : 
                    grid[i][j] = 0
            else : 
                grid[i][j] = next_grid[i][j]


    

count = 0 
for i in range(n):
    for j in range(n):
        if grid[i][j] != 0 :
            for ele in grid[i][j] : 
                count+=1
print(count)
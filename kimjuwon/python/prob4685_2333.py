import sys


def in_range(x,y,n):
    return True if 0 <= x < n and 0 <= y < n else False

def can_move(r, c, n, arr):
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    d = []
    for i in range(4):
        x, y = dx[i], dy[i]
        if in_range(r+x, c+y, n):
            d.append((arr[r+x][c+y], i, r+x, c+y))
    d.sort(key = lambda x: (-x[0], x[1]))
     
    return d[0][2], d[0][3]
   

n, m, t = tuple(map(int, sys.stdin.readline().split()))
arr = [ list(map(int, sys.stdin.readline().split())) for _ in range(n)]
beads = [ list(map(int, sys.stdin.readline().split())) for _ in range(m)]
beads_set = set([])
count = [[ 0 for _ in range(n) ] for _ in range(n)]


for bead in beads : 
    r, c = bead
    r -= 1
    c -= 1
    beads_set.add((r,c))
    count[r][c] = 1

for _ in range(t):
    for bead in beads_set:
        r, c = bead
        count[r][c] -= 1
        r, c = can_move(r, c, n, arr)
        count[r][c] += 1
    
    beads_set = set([])

    for i in range(n):
        for j in range(n):
            if count[i][j] == 1 : 
                beads_set.add((i,j))
            elif count[i][j] >= 2 : 
                count[i][j] = 0 
    

print(len(beads_set))
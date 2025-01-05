import sys 

n, m, r, c = tuple(map(int, sys.stdin.readline().split()))
r -= 1
c -= 1
bomb_set = set([(r, c)])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
def in_range(x, y, n):
    return True if 0 <= x < n and 0 <= y < n else False 



for i in range(1, m+1) : 
    temp_set = set([])
    for bomb in list(bomb_set):
        r, c = bomb
        for x, y in zip(dx, dy):
            k = 2**(i-1)
            if in_range(r+x*k, c+y*k, n) : 
                temp_set.add((r+x*k, c+y*k))
    bomb_set = bomb_set.union(temp_set)
    

print(len(bomb_set))
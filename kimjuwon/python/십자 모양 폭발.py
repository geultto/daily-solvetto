import sys 

n = int(sys.stdin.readline())
arr = [ list(map(int, sys.stdin.readline().split())) for _ in range(n) ]
answer = [[ 0 for _ in range(n)] for _ in range(n)]
r, c = tuple(map(int, sys.stdin.readline().split()))
r, c = r-1, c-1
k = arr[r][c]
dx, dy = [1, 0, 0, -1],[0, 1, -1, 0]
checker = set([])
for i in range(k):
    for x, y in zip(dx, dy):
        new_r, new_c = x*i + r, y*i + c
        if new_r > n-1 : 
            new_r = n-1
        if new_r < 0 : 
            new_r = 0 
        if new_c > n-1 : 
            new_c = n-1
        if new_c < 0 : 
            new_c = 0 
        checker.add((new_r, new_c))

for j in range(n):
    start = n-1 
    for i in range(n-1, -1, -1):
        if (i,j) not in checker:
            answer[start][j] = arr[i][j]
            start -= 1

    
for i in range(n):
    for j in range(n):
        print(answer[i][j], end = " ") 
    print()
import sys 

n, m, k = tuple(map(int, sys.stdin.readline().split()))
arr = [ list(map(int, sys.stdin.readline().split())) for _ in range(n)]

k -= 1 
start_row = n-1

for c in range(k, k+m):
    for r in range(n-1, -1, -1):
        if arr[r][c] : 
            start_row = min(r-1, start_row)

for c in range(k, k+m):
    arr[start_row][c] = 1

for i in range(n):
    for j in range(n):
        print(arr[i][j], end = " ")
    print()
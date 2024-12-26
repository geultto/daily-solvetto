import sys

n = int(sys.stdin.readline())
arr = [ list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0 

def check_range(i, j):
    return True if 0 <= i < n and 0 <= j < n else False

def count_pair(i,j, A):
    dx, dy = [1,0,-1,0],[0,1,0,-1]
    count = 0
    for x, y in zip(dx,dy):
        if check_range(i+x, j+y):
            if A[i+x][j+y] == A[i][j]:
                count += 1
    return count

for i in range(n):
    for j in range(n):
        temp1 = [[arr[r][c] for c in range(n)] for r in range(n)]
        bomb_range = temp1[i][j]

        for r in range(max(0, i-bomb_range+1), min(i+bomb_range, n)):
            temp1[r][j] = 0 
        for c in range(max(0, j-bomb_range+1), min(j+bomb_range, n)):
            temp1[i][c] = 0 

        temp2 = [[0 for _ in range(n)] for _ in range(n)]
        
        for c in range(n):
            end = n - 1
            for r in range(n-1, -1, -1):
                if temp1[r][c] != 0 : 
                    temp2[end][c] = temp1[r][c]
                    end -= 1
        
        count = 0 
        for r in range(n):
            for c in range(n):
                if temp2[r][c] != 0 :
                    count += count_pair(r, c, temp2)
        answer = max(answer, count//2)
        
print(answer)
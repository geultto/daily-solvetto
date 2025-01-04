# https://www.acmicpc.net/problem/1303
from collections import deque

white_total = 0
blue_total = 0

# 가로, 세로 
n, m = map(int, input().split())
arr = []
for _ in range(m):
    arr.append(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x:int, y:int, team:str):
    count = 1 
    queue = deque([(x, y)])
    visited[x][y] = True
    while queue: 
        x, y = queue.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < m and 0 <= ny < n:
                if arr[nx][ny] == team and visited[nx][ny] == False: 
                    visited[nx][ny] = True 
                    count += 1
                    queue.append((nx, ny))
    return count*count

visited = [[False] * n for _ in range(m)]
for i in range(m):
    for j in range(n):
        if arr[i][j] == 'W' and visited[i][j] == False:
            white_total += bfs(i, j, 'W')
        elif arr[i][j] == 'B' and visited[i][j] == False: 
            blue_total += bfs(i, j, 'B')

print(white_total, blue_total)
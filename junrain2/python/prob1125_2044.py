from collections import deque

n, m = map(int, input().split())
graph = [list(input()) for _ in range(n)]

x = y = 0
fire = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == "J":
            x, y = i, j
        if graph[i][j] == "F":
            fire.append((i, j, 1))

distance = [[-1] * m for _ in range(n)]
q = deque(fire + [(x, y, 0)])  # 사람 0, 불 1
distance[x][y] = 0

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

while q:
    x, y, t = q.popleft()
    if (x == n - 1 or x == 0 or y == m - 1 or y == 0) and t == 0:
        print(distance[x][y] + 1)
        exit()
        
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if t == 0:
            if 0 <= nx < n and 0 <= ny < m and distance[nx][ny] == -1 and graph[nx][ny] == ".":
                q.append((nx, ny, 0)) 
                distance[nx][ny] = distance[x][y] + 1
        else:
            if 0 <= nx < n and 0 <= ny < m and (graph[nx][ny] == "." or graph[nx][ny] == "J"):
                graph[nx][ny] = 'F'
                q.append((nx, ny, 1))    
                
print("IMPOSSIBLE")
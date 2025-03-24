from collections import deque

n, m, k = map(int, input().split())

graph = [[0] * m for _ in range(n)]
for i in range(k):
    x, y = map(int, input().split())
    graph[x - 1][y - 1] = 1
    
def bfs(x, y, visited):
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    q = deque([(x, y)])
    visited[x][y]  = True
    
    cnt = 1
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = True
                cnt += 1
    return cnt

cnt = 0
visited = [[False] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            cnt = max(cnt, bfs(i, j, visited))
            
print(cnt)
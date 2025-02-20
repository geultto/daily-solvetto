from collections import deque

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

상어 = 2
sx = sy = 0

for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            sx, sy = i, j
            graph[i][j] = 0

음식 = 0

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y):
    visited = [[-1] * n for _ in range(n)]
    q = deque([(x, y)])
    visited[x][y] = 0
    dist = []
    
    while q:
        global 음식
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1 and graph[nx][ny] <= 상어:
                if 0 < graph[nx][ny] < 상어:
                    dist.append((visited[x][y] + 1, nx, ny))
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

    return dist

answer = 0
while True:
    dist = bfs(sx, sy)
    if not dist:
        break
    
    dist.sort()
    cnt, sx, sy = dist[0]
    graph[sx][sy] = 0
    음식 += 1
    
    if 음식 == 상어:
        상어 += 1
        음식 = 0
    answer += cnt
    
print(answer)
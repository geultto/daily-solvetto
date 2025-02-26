from collections import deque

m, n, k = map(int, input().split())
graph = [[0] * n for _ in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] += 1

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def bfs(y, x, visited):
    q = deque([(x, y)])
    visited[y][x] = True
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if (
                0 <= nx < n
                and 0 <= ny < m
                and graph[ny][nx] == 0
                and not visited[ny][nx]
            ):
                cnt += 1
                q.append((nx, ny))
                visited[ny][nx] = True

    return cnt


answer = []
visited = [[False] * n for _ in range(m)]
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0 and not visited[i][j]:
            answer.append(bfs(i, j, visited))

answer.sort()
print(len(answer))
print(*answer)
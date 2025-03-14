from collections import deque

# 강은 간선, 물이 흐르는 방향이 간선의 방향
# 노드는 호수, 바다
for tc in range(int(input())):
    k, m, p = map(int, input().split())
    indegrees = [0] * (m + 1)
    graph = [[] for _ in range(m + 1)]
    
    for i in range(p):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegrees[b] += 1
    
    q = deque()
    orders = [1] * (m + 1) # 노드들의 레벨을 기록
    indegrees_vertex = [[] for _ in range(m + 1)] # 진입차수들의 순서 기록
    
    for i in range(1, m + 1):
        if indegrees[i] == 0:
            q.append(i)
            
    while q:
        v = q.popleft()
        for i in graph[v]:
            indegrees[i] -= 1
            indegrees_vertex[i].append(orders[v])
            orders[i] = max(max(indegrees_vertex[i]), orders[i])
            if indegrees_vertex[i].count(orders[i]) >= 2:
                orders[i] += 1
            
            if indegrees[i] == 0:
                q.append(i)
    
    print(k, max(orders))
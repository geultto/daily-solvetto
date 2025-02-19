INF = int(1e9)

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())  # 회의에 참석하는 수 -> 노드
parent = list(range(n + 1))
distance = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    distance[i][i] = 0

m = int(input())  # 서로 알고 있는 수 -> 간선

array = []
for i in range(m):
    a, b = map(int, input().split())
    distance[a][b] = 1
    distance[b][a] = 1
    array.append((a, b))

# 플로이드-워셜
for k in range(1, n +1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            distance[a][b] = min(distance[a][b], distance[a][k] + distance[k][b])
            
for a, b in array:
    union_parent(parent, a, b)

for i in range(1, n + 1):
    find_parent(parent, i)

d = dict()
for i in range(1, n + 1):
    if parent[i] not in d.keys():
        d[parent[i]] = list()
    d[parent[i]].append(i)

result = []
for k in d.keys():
    value = INF
    index = k
    for v in d[k]:
        distance[v] = list(map(lambda x : -1 if x == INF else x, distance[v]))
        if value > max(distance[v]):
            index = v
            value =  max(distance[v])
    result.append(index)

result = list(set(result))
result.sort()
print(len(result))
for r in result:
    print(r)
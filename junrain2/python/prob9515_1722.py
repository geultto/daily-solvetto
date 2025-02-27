import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = list(range(n + 1))

result = 0
for i in range(m):
    a, b = map(int, input().split())
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
    else:
        result += 1

for i in range(1, n + 1):
    find_parent(parent, i)

parent = set(parent)
parent.remove(0)

# 연결 해야하는 경우의 수
print(result + len(parent) - 1)
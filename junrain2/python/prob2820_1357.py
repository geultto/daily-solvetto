import sys
sys.setrecursionlimit(10**5)

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent ,a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())

parent = list(range(n + 1))

for _ in range(m):
    c, a, b = map(int, input().split())
    if c == 0:
        union(parent, parent[a], parent[b])
    else:
        if find(parent, a) != find(parent, b):
            print("NO")
        else:
            print("YES")
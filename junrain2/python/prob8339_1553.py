n = int(input())
m = int(input())
array = [int(input()) for _ in range(m)]

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

parent = list(range(n + 1))

result = 0
for i in array:
    data = find_parent(parent, i)
    if data == 0:
        break
    union_parent(parent, data, data -1)
    result += 1

print(result)
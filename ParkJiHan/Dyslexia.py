n = int(input())
a = input().strip()
b = input().strip()
c = 0
for i in range(n):
    if a[i] != b[i]:
        c += 1
print(c)
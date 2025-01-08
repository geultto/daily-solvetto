n = 4
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))
    print(sum(arr[_]))
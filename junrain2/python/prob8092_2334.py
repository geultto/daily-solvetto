n = int(input())

array = list(map(int, input().split()))
s = [array[0]]

for i in range(1, n):
    s.append(max(s[-1] + array[i], array[i]))
    
print(max(s))
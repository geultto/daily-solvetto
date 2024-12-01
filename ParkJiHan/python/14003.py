# 백준 14003.가장 긴 증가하는 부분 순열 5 (https://www.acmicpc.net/problem/14003)

N = int(input())
A = list(map(int,input().split()))

dp = [1 for _ in range(N)]
prev = [-1 for _ in range(N)]
find = [(-1000000001, -1)]
for i in range(N):
    a = A[i]
    start, end = 0, len(find) - 1
    while start <= end:
        mid = (start + end) // 2
        if a == find[mid][0]:
            break
        elif a < find[mid][0]:
            end = mid - 1
        else:
            start = mid + 1
    
    if find[mid][0] < a:
        if mid < len(find) - 1:
            find[mid + 1] = (a, i)
        else:
            find.append((a, i))
        dp[i] = mid + 1
        prev[i] = find[mid][1]
    else:
        find[mid] = (a, i)
        dp[i] = mid
        prev[i] = find[mid - 1][1]

LIS = []
i = find[-1][1]
while i > -1:
    LIS.append(A[i])
    i = prev[i]

print(max(dp))
print(*LIS[::-1])
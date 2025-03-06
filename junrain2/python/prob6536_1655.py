import sys
input = sys.stdin.readline

n = int(input())
s = list(map(int, input().split()))
s = [0] + s

dp = [[True] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    dp[i][i] = True

for i in range(n - 1, 0 , -1):
    for j in range(i + 1, n + 1):
        dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]

for _ in range(int(input())):
    a, b = map(int, input().split())
    print(1 if dp[a][b] else 0)
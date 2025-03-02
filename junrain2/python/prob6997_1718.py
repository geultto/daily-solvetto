n, k = map(int, input().split())

dp = [[0] * (201) for _ in range(201)]

for i in range(1, n + 1):
    dp[1][i] = 1
    dp[2][i] = i + 1

for i in range(3, k + 1):
    for j in range(1, n + 1):
        if j == 1:
            dp[i][j] = i
        else:
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        
print(dp[k][n] % int((1e9)))
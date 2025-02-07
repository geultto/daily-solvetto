import sys

n = int(sys.stdin.readline())
matrix = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    for j in range(i + 1):
        if j == 0 or j == n - 1:
            matrix[i][j] = 1
        else:
            matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1]

for i in range(n):
    print(' '.join(str(x) for x in matrix[i][:i + 1]))
# 십자 모양의 지속적 폭발
# 문제 링크 : https://www.codetree.ai/missions/2/problems/cross-shape-continuous-bomb?&utm_source=clipboard&utm_medium=text
import sys

n, m = tuple(map(int, sys.stdin.readline().split()))
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
bombs = [int(sys.stdin.readline()) for _ in range(m)]


for c in bombs:
    temp = [[0 for _ in range(n)] for _ in range(n)]
    c -= 1

    for r in range(n):
        if arr[r][c] != 0:
            break

    bomb_range = arr[r][c]
    if bomb_range != 0:
        for i in range(max(0, c - bomb_range + 1), min(bomb_range + c, n)):
            arr[r][i] = 0

        for i in range(max(0, r - bomb_range + 1), min(bomb_range + r, n)):
            arr[i][c] = 0

    for j in range(n):
        end = n - 1
        for i in range(n - 1, -1, -1):
            if arr[i][j] != 0:
                temp[end][j] = arr[i][j]
                end -= 1

    for i in range(n):
        for j in range(n):
            arr[i][j] = temp[i][j]


for i in range(n):
    for j in range(n):
        print(arr[i][j], end=" ")
    print()

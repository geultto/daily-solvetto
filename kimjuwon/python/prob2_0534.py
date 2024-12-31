import sys

n, m, k = tuple(map(int, sys.stdin.readline().split()))
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]


def find_consecutive_number(arr, r, c, n):
    check_last = r
    while check_last < n and arr[check_last][c] == arr[r][c]:
        check_last += 1
    count = check_last - r
    return check_last, count


for _ in range(k):
    temp = [[0 for _ in range(n)] for _ in range(n)]

    bombcount = True
    while bombcount is True:
        temp = [[0 for _ in range(n)] for _ in range(n)]
        bombcount = False
        for c in range(n):
            for r in range(n):
                if arr[r][c] != 0:
                    check_last, count = find_consecutive_number(arr, r, c, n)
                    if count >= m:
                        for i in range(r, check_last):
                            arr[i][c] = 0
                            bombcount = True

        for c in range(n):
            end = n - 1
            for r in range(n - 1, -1, -1):
                if arr[r][c] != 0:
                    temp[end][c] = arr[r][c]
                    end -= 1
        for i in range(n):
            for j in range(n):
                arr[i][j] = temp[i][j]

    for i in range(n):
        for j in range(n):
            temp[j][n - 1 - i] = arr[i][j]
    
    arr = [[0 for _ in range(n)] for _ in range(n)]

    for c in range(n):
        end = n - 1
        for r in range(n - 1, -1, -1):
            if temp[r][c] != 0:
                arr[end][c] = temp[r][c]
                end -= 1


bombcount = True
while bombcount is True:
    bombcount = False
    temp = [[0 for _ in range(n)] for _ in range(n)]
    for c in range(n):
        for r in range(n):
            if arr[r][c] != 0:
                check_last, count = find_consecutive_number(arr, r, c, n)
                if count >= m:
                    for i in range(r, check_last):
                        arr[i][c] = 0
                        bombcount = True
                        

    for c in range(n):
        end = n - 1
        for r in range(n - 1, -1, -1):
            if arr[r][c] != 0:
                temp[end][c] = arr[r][c]
                end -= 1

    for i in range(n):
        for j in range(n):
            arr[i][j] = temp[i][j]



answer = 0

for i in range(n):
    for j in range(n):
        answer += 1 if arr[i][j] else 0

print(answer)
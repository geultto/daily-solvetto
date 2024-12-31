import sys 

arr = [ list(map(int, sys.stdin.readline().split())) for _ in range(4)]
d = sys.stdin.readline().rstrip()
temp = [[ 0 for _ in range(4)] for _ in range(4)]

if d == "R":
    for i in range(4):
        end = 3 
        check = False
        for j in range(3, -1, -1):
            if j == 3 or end == 3: 
                if arr[i][j] != 0 : 
                    temp[i][end] = arr[i][j]
                    end -= 1
            else : 
                if arr[i][j] != 0 : 
                    if arr[i][j] == temp[i][end+1] and check is False:
                        temp[i][end+1] += arr[i][j]
                        check = True
                    else : 
                        temp[i][end] = arr[i][j]
                        check = False
                        end -= 1
elif d == "L" : 
    for i in range(4):
        end = 0
        check = False
        for j in range(4):
            if j == 0 or end == 0: 
                if arr[i][j] != 0: 
                    temp[i][end] = arr[i][j]
                    end += 1
            else : 
                if arr[i][j] != 0 : 
                    if arr[i][j] == temp[i][end-1] and check is False:
                        temp[i][end-1] += arr[i][j]
                        check = True
                    else : 
                        temp[i][end] = arr[i][j]
                        check = False
                        end += 1

elif d == "U" : 
    for j in range(4):
        end = 0
        check = False
        for i in range(4):
            if i == 0 : 
                if arr[i][j] != 0 : 
                    temp[end][j] = arr[i][j]
                    end += 1
            else : 
                if arr[i][j] != 0 : 
                    if arr[i][j] == temp[end-1][j] and check is False:
                        temp[end-1][j] += arr[i][j]
                        check = True
                    else : 
                        temp[end][j] = arr[i][j]
                        check = False
                        end += 1


if d == "D":
    for j in range(4):
        end = 3 
        check = False
        for i in range(3, -1, -1):
            if i == 3 or end == 3: 
                if arr[i][j] != 0 : 
                    temp[end][j] = arr[i][j]
                    end -= 1
            else : 
                if arr[i][j] != 0 : 
                    if arr[i][j] == temp[end+1][j] and check is False:
                        temp[end+1][j] += arr[i][j]
                        check = True
                    else : 
                        temp[end][j] = arr[i][j]
                        check = False
                        end -= 1



for i in range(4):
    for j in range(4):
        print(temp[i][j], end =" ")
    print()
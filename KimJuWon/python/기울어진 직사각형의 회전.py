import sys

n = int(sys.stdin.readline())
arr = [ list(map(int, sys.stdin.readline().split()))for _ in range(n)]
r, c, m1, m2, m3, m4, d = map(int, sys.stdin.readline().split())
r -= 1
c -= 1

dx, dy = [-1, -1, 1, 1], [1, -1, -1, 1]
if d == 0 : 
    temp = arr[r-1][c-1]
    temp2 = arr[r+(m1*-1)+1][c+m1-1]
    for i in range(m1-1):
        arr[r+(m1-1)*(-1)+i][c+(m1-1)-i] =  arr[r+(m1-2)*(-1)+i][c+(m1-2)-i]
    arr[r][c] = temp
    r += m1 * -1
    c += m1 

    temp = temp2 
    temp2 = arr[r+(m2*-1)+1][c+(m2*-1)+1]
    for i in range(m2-1):
        arr[r+(m2-1)*(-1)+i][c+(m2-1)*(-1)+i ] = arr[r+(m2-2)*(-1)+i][c+(m2-2)*(-1)+i ] 
    arr[r][c] = temp
    r += m2 * -1
    c += m2 * -1

    temp = temp2 
    temp2 = arr[r+(m3)-1][c+(m3*-1)+1]    
    for i in range(m3-1):
        arr[r+(m3-1)-i][c+(m3-1)*(-1)+i] = arr[r+(m3-2)-i][c+(m3-2)*(-1)+i]
    arr[r][c] = temp 
    r += m3 
    c += m3 * -1

    temp = temp2 
    for i in range(m4-1):
        arr[r+(m4-1)-i][c+(m4-1)-i] = arr[r+(m4-2)-i][c+(m4-2)-i] 
    arr[r][c] = temp
else : 
    temp = arr[r-1][c+1]
    temp2 = arr[r+(m4-1)*-1][c+(m4-1)*-1]
    for i in range(m4-1):
        arr[r+(m4-1)*-1+i][c+(m4-1)*-1+i] = arr[r+(m4-2)*-1+i][c+(m4-2)*-1+i]
    arr[r][c] = temp 
    r += m4 * -1
    c += m4 * -1

    temp = temp2 
    temp2 = arr[r+(m3-1)*-1][c+(m3-1)]
    for i in range(m3-1) : 
        arr[r+(m3-1)*-1+i][c+(m3-1)-i] = arr[r+(m3-2)*-1+i][c+(m3-2)-i]
    arr[r][c] = temp 
    r += m3 * -1 
    c += m3 
    
    temp = temp2 
    temp2 = arr[r+(m2-1)][c+(m2-1)]
    for i in range(m2-1):
        arr[r+(m2-1)-i][c+(m2-1)-i] = arr[r+(m2-2)-i][c+(m2-2)-i]
    arr[r][c] = temp 
    r += m2
    c += m2 

    temp = temp2 
    for i in range(m1-1):
        arr[r+(m1-1)-i][c+(m1-1)*-1+i] = arr[r+(m1-2)-i][c+(m1-2)*-1+i] 
    arr[r][c] = temp


for i in range(n):
    for j in range(n):
        print(arr[i][j], end = " ")
    print()
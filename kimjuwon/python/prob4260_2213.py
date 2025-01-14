import sys

T = int(sys.stdin.readline())

d_dict = {
    "U":[-1,0],
    "D":[1,0],
    "L":[0,-1],
    "R":[0,1]
}

transform = {
    "U":"D", 
    "L":"R", 
    "D":"U", 
    "R":"L", 
}

def in_range(x,y,n):
    return True if 0 <= x < n and 0 <= y < n else False 

for _ in range(T):
    n, m = tuple(map(int, sys.stdin.readline().split()))
    arr = [[ 0 for _ in range(n)] for _ in range(n)]
    n_arr = [[ 0 for _ in range(n)] for _ in range(n)]
    beads = [ sys.stdin.readline().split() for _ in range(m)]
    
    for i in range(m):
        r, c, d = beads[i]
        arr[int(r)-1][int(c)-1] = d
    
    for _ in range(2*n):
        for i in range(n):
            for j in range(n):
                if arr[i][j] != 0 : 
                    d = arr[i][j]
                    x, y = d_dict[d]
                    if in_range(i+x, j+y, n):
                        if n_arr[i+x][j+y] == 0 : 
                            n_arr[i+x][j+y] = d 
                        else : 
                            n_arr[i+x][j+y] = -1
                    else : 
                        d = transform[d]
                        
                        if n_arr[i][j] == 0 : 
                            n_arr[i][j] = d
                        else : 
                            n_arr[i][j] = -1

        for i in range(n):
            for j in range(n):
                if n_arr[i][j] != -1:
                    arr[i][j] = n_arr[i][j]
                else : 
                    arr[i][j] = 0 
                n_arr[i][j] = 0

    count = 0 
    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                count += 1
    print(count)
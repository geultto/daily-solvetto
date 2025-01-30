import sys 

k, n = tuple(map(int, sys.stdin.readline().split()))


def k_n_pick_print(arr, k, n):
    if len(arr) == n : 
        for i in range(n) : 
            print(arr[i], end= " ")
        print()
    else : 
        for i in range(1, k+1):
            arr.append(i)
            k_n_pick_print(arr, k, n)
            arr.pop()


arr = []
k_n_pick_print(arr,k,n)
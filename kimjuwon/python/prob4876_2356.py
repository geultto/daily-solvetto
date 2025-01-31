import sys 

n = int(sys.stdin.readline())
count = 0 
arr = []
def beautiful_num(arr, n):
    global count
    if len(arr) == n : 
        count += 1
    elif len(arr) < n : 
        for i in range(1, 5):
            for _ in range(i):
                arr.append(i)
            beautiful_num(arr, n)
            for _ in range(i):
                arr.pop()

beautiful_num(arr, n)

print(count)
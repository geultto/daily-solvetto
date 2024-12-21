import sys

n, m = tuple(map(int, sys.stdin.readline().split()))
arr = [int(sys.stdin.readline()) for _ in range(n)]

changed = True
while changed is True:
    changed = False
    temp = []
    checkers = []
    new = True
    bomb = False
    start, end = -1, -1
    count = 0
    for i in range(1, len(arr)):
        if arr[i] == arr[i - 1]:
            if new is True:
                start = i - 1
                bomb = True
                new = False
                count = 2
            elif new is False:
                count += 1
            if i == len(arr) - 1 and count >= m:
                end = i
                checkers.append((start, end))
                changed = True
        else:
            if bomb is True:
                end = i - 1
                if count >= m:
                    checkers.append((start, end))
                    changed = True
                bomb = False
                new = True
                count = 0
    check_set = set([])

    for checker in checkers:
        s, e = checker
        for i in range(s, e + 1):
            check_set.add(i)

    for i in range(len(arr)):
        if i not in check_set:
            temp.append(arr[i])

    arr = []
    for ele in temp:
        arr.append(ele)
        

if m != 1 : 
    print(len(arr))
    for ele in arr:
        print(ele)
else : 
    print(0)
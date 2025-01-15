N=int(input())
S=sum(list(map(int,input().split())))
print('Stay' if S == 0 else 'Left' if S < 0 else 'Right')
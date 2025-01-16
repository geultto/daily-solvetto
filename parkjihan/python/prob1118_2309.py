n=int(input())
a=0
for c in list(map(int,input().split())):
    a += 1 if c % 2 == 0 else -1
print('Happy' if a > 0 else 'Sad')
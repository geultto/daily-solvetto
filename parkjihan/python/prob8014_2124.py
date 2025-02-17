print('Gnomes:')
for _ in range(int(input())):
    a,b,c = map(int,input().split())
    print('Ordered' if a>b>c or a<b<c else 'Unordered')
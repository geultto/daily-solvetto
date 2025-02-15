SUM, SUB = map(int,input().split())
if SUM < SUB:
    print(-1)
    exit()
x = (SUM + SUB) // 2
y = SUM - x
if x + y == SUM and x - y == SUB:
    print(x, y)
else:
    print(-1)
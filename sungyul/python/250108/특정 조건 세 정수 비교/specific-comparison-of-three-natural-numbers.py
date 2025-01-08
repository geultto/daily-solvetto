a, b, c = map(int, input().split())


print(1, end=" ") if (a<=b and a<=c) else print(0, end=" ")
print(1) if (a==b and a==c) else print(0)
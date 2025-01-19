n = input()
a, b = '7' in n, int(n) % 7 == 0
print(3 if a and b else 2 if a else 1 if b else 0)
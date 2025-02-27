from itertools import combinations

l, c = map(int, input().split())

모음 = set(['a', 'e', 'i', 'o', 'u'])

array = list(input().split())
a = [] # 모음
b = [] # 자음

for i in array:
    if i in 모음:
        a.append(i)
    else:
        b.append(i)

result = []        
for i in range(1, min(len(a) + 1, l - 1)):
    for j in list(combinations(a, i)):
        for k in list(combinations(b, l - i)):
            tmp = j + k
            result.append("".join(sorted(tmp)))

for i in sorted(result):
    print(i)
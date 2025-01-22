import sys

centers = [0] * 4
for _ in range(3):
    a, b = sys.stdin.readline().rstrip().split()

    if a == 'Y' and int(b) >= 37:
        centers[0] += 1
    elif a == 'N' and int(b) >= 37:
        centers[1] += 1
    elif a == 'Y':
        centers[2] += 1
    else:
        centers[3] += 1

answer = ' '.join(str(x) for x in centers)
if centers[0] >= 2:
    answer = f'{answer} E'

print(answer)
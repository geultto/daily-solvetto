import sys

string = sys.stdin.readline().rstrip()
answer = []
current = string[0]
pos = 1
cnt = 1

while pos < len(string):
    if string[pos] == current:
        cnt += 1
    else:
        answer.append(current)
        answer.append(str(cnt))
        current = string[pos]
        cnt = 1
    pos += 1

answer.append(current)
answer.append(str(cnt))
answer = ''.join(answer)
print(f'{len(answer)}\n{answer}')
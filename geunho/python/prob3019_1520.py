import sys

document = sys.stdin.readline().rstrip()
query = sys.stdin.readline().rstrip()

answer = 0
while document:
    if document.startswith(query):
        document = document[len(query) :]
        answer += 1
    else:
        document = document[1:]

print(answer)
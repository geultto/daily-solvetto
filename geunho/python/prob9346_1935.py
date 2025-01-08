import sys

string = sys.stdin.readline().rstrip()
stack = []

for char in string:
    if not stack:
        stack.append(char)
        continue
    
    if char == '(':
        stack.append(char)
    else:
        if stack[-1] == '(':
            stack.pop()
        else:
            break

answer = 'No' if stack else 'Yes'
print(answer)
import sys

string, q = sys.stdin.readline().rstrip().split()
answer = []
for _ in range(int(q)):
    command = int(sys.stdin.readline())
    
    if command == 1:
        string = string[1:] + string[0]
    elif command == 2:
        string = string[-1] + string[:-1]
    else:
        string = string[::-1]
    
    answer.append(string)

print('\n'.join(answer))
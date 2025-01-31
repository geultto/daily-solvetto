import sys

string, num_of_queries = sys.stdin.readline().rstrip().split()
answer = []
for _ in range(int(num_of_queries)):
    command, a, b = sys.stdin.readline().rstrip().split()

    if command == '1':
        a, b = int(a), int(b)
        temp = []
        for index, char in enumerate(string):
            if index == a - 1:
                temp.append(string[b - 1])
            elif index == b - 1:
                temp.append(string[a - 1])
            else:
                temp.append(char)

        string = ''.join(temp)
        answer.append(string)
    else:
        temp = []
        for char in string:
            temp.append(b if char == a else char)
        string = ''.join(temp)
        answer.append(string)

print('\n'.join(answer))
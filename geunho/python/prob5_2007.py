import sys

num_of_commands = int(sys.stdin.readline())
arr = []
answer = []
for _ in range(num_of_commands):
    args = sys.stdin.readline().rstrip().split()

    command = args[0]
    if command == 'push_back':
        arr.append(int(args[1]))
    elif command == 'pop_back':
        arr.pop()
    elif command == 'size':
        answer.append(len(arr))
    else:  # command == 'get'
        answer.append(arr[int(args[1]) - 1])

print('\n'.join((str(x) for x in answer)))
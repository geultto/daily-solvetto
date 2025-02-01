import sys

num_of_elements, num_of_queries = [int(x) for x in sys.stdin.readline().split()]
elements = [int(x) for x in sys.stdin.readline().split()]
index_by_element = {}
for index, element in enumerate(elements):
    if element in index_by_element:
        continue
    index_by_element[element] = index + 1

answer = []
for _ in range(num_of_queries):
    command, *args = [int(x) for x in sys.stdin.readline().split()]
    if command == 1:
        answer.append(str(elements[int(args[0]) - 1]))
    elif command == 2:
        index = index_by_element.get(int(args[0]), 0)
        answer.append(str(index))
    else:
        start, end = args
        answer.append(' '.join(str(x) for x in elements[start - 1 : end]))

print('\n'.join(answer))
import sys

n, m = [int(x) for x in sys.stdin.readline().split()]
grid = []
answer = 0

if m == 1:
    for _ in range(n):
        row = [int(x) for x in sys.stdin.readline().split()]
        grid.append(row)
    
    print(2 * n)
else:
    for _ in range(n):
        row = [int(x) for x in sys.stdin.readline().split()]
        grid.append(row)
    
        current = row[0]
        count = 1
        for element in row[1:]:
            if element == current:
                count += 1
                if count >= m:
                    answer += 1
                    break
            else:
                current = element
                count = 1
    
    for col in range(n):
        current = grid[0][col]
        count = 1
        for index in range(1, n):
            element = grid[index][col]
            if element == current:
                count += 1
                if count >= m:
                    answer += 1
                    break
            else:
                current = element
                count = 1

    print(answer)
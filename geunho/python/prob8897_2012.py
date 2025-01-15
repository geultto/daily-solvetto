import sys
from typing import Sequence, Tuple

n, m = [int(x) for x in sys.stdin.readline().split()]
grid = []
for _ in range(n):
    row = [int(x) for x in sys.stdin.readline().split()]
    grid.append(row)


def is_valid_coordinates(r: int, c: int) -> bool:
    return 0 <= r < n and 0 <= c < m


def is_valid_block(coordinates: Sequence[Tuple[int, int]]) -> bool:
    return all(is_valid_coordinates(r, c) for r, c in coordinates)


def calculate_block_score(coordinates: Sequence[Tuple[int, int]]) -> int:
    result = 0
    for r, c in coordinates:
        result += grid[r][c]
    return result


answer = 0
checked = set()
for row in range(n):
    for col in range(m):
        coordinates = ((row, col), (row + 1, col), (row + 1, col + 1))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

        coordinates = ((row, col), (row + 1, col), (row + 1, col - 1))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

        coordinates = ((row, col), (row + 1, col), (row, col + 1))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

        coordinates = ((row, col), (row + 1, col), (row, col - 1))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

        coordinates = ((row, col), (row, col + 1), (row, col + 2))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

        coordinates = ((row, col), (row + 1, col), (row + 2, col))
        if is_valid_block(coordinates) and coordinates not in checked:
            answer = max(answer, calculate_block_score(coordinates))
            checked.add(coordinates)

print(answer)
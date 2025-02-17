import sys

def swap(a: int, b: int) -> tuple[int, int]:
    return b, a


n, m = [int(x) for x in sys.stdin.readline().split()]
print(' '.join(str(x) for x in swap(n, m)))
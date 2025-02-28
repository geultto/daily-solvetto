import heapq
INF = int(2147483648)

n, m = map(int, input().split())

data = dict()
for i in range(n):
    # 무게, 가격
    a, b = map(int, input().split())
    if b not in data:
        data[b] = list()
    heapq.heappush(data[b], -a)

s = 0
answer = INF

for i in sorted(data.keys()):
    price = 0
    while data[i]:
        price += i
        s -= heapq.heappop(data[i])
        if s >= m:
            answer = min(answer, price)

if answer == INF:
    print(-1)
else:
    print(answer)
d,h,m = map(int,input().split())
start = 11 + (11 * 24 + 11) * 60
end = m + (d * 24 + h) * 60
print(-1 if start > end else end - start)
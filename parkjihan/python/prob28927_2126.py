a,b,c=map(int,input().split())
d,e,f=map(int,input().split())
x=a*3+b*20+c*120
y=d*3+e*20+f*120
print('Max' if x > y else 'Mel' if x < y else 'Draw')
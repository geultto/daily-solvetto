while True:
    n = float(input())
    if n < 0:
        break
    print("Objects weighing %.2f on Earth will weigh %.2f on the moon."%(n,n*0.167))
h, w = map(int, input().split())

BMI = (w*10000) // (h*h)


print(BMI)
if(BMI >= 25):
    print("Obesity")
let n = Int(readLine()!)!

func stairs(_ number: Int) -> Int {
    var stairs = [0, 0, 1, 1]

    if number >= 4 {
        for i in 4...number {
            stairs.append((stairs[i-2] + stairs[i-3]) % 10007) 
        }
    }

    return stairs[number]
}

print(stairs(n))
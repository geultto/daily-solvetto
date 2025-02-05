let n = Int(readLine()!)!

func rectangles(_ number: Int) -> Int {
    var cases = [0, 1, 2]

    if number >= 3 {
        for i in 3...number {
            cases.append((cases[i-1] + cases[i-2]) % 10007)
        }
    }

    return cases[number]
}

print(rectangles(n))
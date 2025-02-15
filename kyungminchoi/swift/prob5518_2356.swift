// Wrote after seeing the solution

class Solution {
    func punishmentNumber(_ n: Int) -> Int {
        var result = 0

        for i in 1...n {
            let square = i * i
            let stringNumber = String(square)

            var memo = Array(repeating: Array(repeating: -1, count: i + 1), count: stringNumber.count)

            if findPartitions(0, 0, stringNumber, i, &memo) {
                result += square
            }
        }

        return result
    }

    func findPartitions(_ starting: Int, _ current: Int, _ stringNumber: String, _ target: Int, _ memo: inout [[Int]]) -> Bool {
        var stringNumberArray = stringNumber.map { String($0) }

        if starting == stringNumberArray.count {
            return current == target
        }

        if current > target {
            return false
        }

        if memo[starting][current] != -1 {
            return memo[starting][current] == 1
        }

        var partitionFound = false

        for currentIndex in starting..<stringNumberArray.count {
            let currentArray = stringNumberArray[starting..<currentIndex + 1]
            let currentNumber = Int(currentArray.joined())!

            partitionFound = partitionFound || findPartitions(
                currentIndex + 1,
                current + currentNumber,
                stringNumber,
                target,
                &memo
            )

            if partitionFound {
                memo[starting][current] = 1
                return true
            }
        }

        memo[starting][current] = 0
        return false
    }
}